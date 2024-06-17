<template>
  <div>
    <!--页面区域-->
    <div class="page-view">
      <div class="table-operations">
        <a-space>
          <a-button type="primary" @click="handleAdd">新增</a-button>
          <a-input-search addon-before="用户名" enter-button @search="onSearch" @change="onSearchChange" />
        </a-space>
      </div>
      <a-table
        size="middle"
        rowKey="id"
        :loading="data.loading"
        :columns="columns"
        :data-source="data.vipList"
        :scroll="{ x: 'max-content' }"
        :row-selection="rowSelection"
        :pagination="{
          size: 'default',
          current: data.page,
          pageSize: data.pageSize,
          onChange: (current) => (data.page = current),
          showSizeChanger: false,
          showTotal: (total) => `共${total}条数据`,
        }"
      >
        <template #bodyCell="{ text, record, index, column }">
          <template v-if="column.key === 'role'">
            <span>
              <span v-if="text === '1'">普通用户</span>
              <span v-if="text === '2'">演示帐号</span>
              <span v-if="text === '3'">管理员</span>
            </span>
          </template>
          <template v-if="column.key === 'operation'">
            <span>
              <a @click="handleEdit(record)">编辑</a>
            </span>
          </template>
        </template>
      </a-table>
    </div>

    <!--弹窗区域-->
    <div>
      <a-modal
        :visible="modal.visile"
        :forceRender="true"
        :title="modal.title"
        ok-text="确认"
        cancel-text="取消"
        @cancel="handleCancel"
        @ok="handleOk"
      >
        <div>
          <a-form ref="myform" :label-col="{ style: { width: '80px' } }" :model="modal.form" :rules="modal.rules">
            <a-row :gutter="24">
              <a-col span="24">
                <a-form-item label="姓名" name="name">
                  <a-input :disabled="modal.editFlag" placeholder="请输入" v-model:value="modal.form.name" allowClear />
                </a-form-item>
              </a-col>
              <a-col span="24" v-if="!modal.editFlag">
                <a-form-item label="性别" name="sex">
                  <a-input placeholder="请输入" v-model:value="modal.form.sex" allowClear />
                </a-form-item>
              </a-col>
              <a-col span="24">
                <a-form-item label="身份证号" name="card">
                  <a-input placeholder="请输入" v-model:value="modal.form.card" allowClear />
                </a-form-item>
              </a-col>
              <a-col span="24">
                <a-form-item label="手机号" name="phone">
                  <a-input placeholder="请输入" v-model:value="modal.form.phone" allowClear />
                </a-form-item>
              </a-col>
              <a-col span="24">
                <a-form-item label="会员类型" name="vtype">
                  <a-select placeholder="请选择" allowClear v-model:value="modal.form.vtype">
                    <a-select-option key="0" value="0">普通会员</a-select-option>
                    <a-select-option key="1" value="1">超级会员</a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col span="24">
                <a-form-item label="生效时间" name="startTime">
                  <a-input placeholder="请输入" v-model:value="modal.form.startTime" allowClear />
                </a-form-item>
              </a-col>
              <a-col span="24">
                <a-form-item label="结束时间" name="endTime">
                  <a-input placeholder="请输入" v-model:value="modal.form.endTime" allowClear />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </div>
      </a-modal>
    </div>
  </div>
</template>

<script setup lang="ts">
  import { FormInstance, message } from 'ant-design-vue';
  import { createApi, listApi, updateApi, deleteApi } from '/@/api/vip';
  import { getFormatTime } from '/@/utils';

  const MOCK_USERS = [
    {
      index: '1',
      username: 'admin123',
      role: '管理员',
      email: '23222@qq.com',
      remark: '我是备注 我是备注11112233',
    },
    {
      index: '1',
      username: 'admin123',
      role: '管理员',
      email: '23222@qq.com',
      remark: '我是备注 我是备注11112233',
    },
    {
      index: '1',
      username: 'admin123',
      role: '管理员',
      email: '23222@qq.com',
      remark: '我是备注 我是备注11112233',
    },
  ];

  const columns = reactive([
    {
      title: '序号',
      dataIndex: 'index',
      key: 'index',
      align: 'center',
    },
    {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
      align: 'center',
    },
    {
      title: '性别',
      dataIndex: 'sex',
      key: 'sex',
      align: 'center',
    },
    {
      title: '身份证号',
      dataIndex: 'card',
      key: 'card',
      align: 'center',
    },
    {
      title: '手机号',
      dataIndex: 'phone',
      key: 'phone',
      align: 'center',
    },
    {
      title: '会员类型',
      dataIndex: 'vtype',
      key: 'vtype',
      align: 'center',
      customRender: ({ text, record, index, column }) => (text === '0' ? '普通会员' : '超级会员'),
    },
    {
      title: '生效时间',
      dataIndex: 'startTime',
      key: 'startTime',
      align: 'center',
    },
    {
      title: '结束时间',
      dataIndex: 'endTime',
      key: 'endTime',
      align: 'center',
    },
    {
      title: '操作',
      dataIndex: 'action',
      key: 'operation',
      align: 'center',
      fixed: 'right',
      width: 140,
    },
  ]);

  const beforeUpload = (file: File) => {
    // 改文件名
    const fileName = new Date().getTime().toString() + '.' + file.type.substring(6);
    const copyFile = new File([file], fileName);
    console.log(copyFile);
    modal.form.cover = copyFile;
    return false;
  };

  const fileList = ref([]);

  // 页面数据
  const data = reactive({
    vipList: [],
    loading: false,
    currentAdminUserName: '',
    keyword: '',
    selectedRowKeys: [] as any[],
    pageSize: 10,
    page: 1,
  });

  // 弹窗数据源
  const modal = reactive({
    visile: false,
    editFlag: false,
    title: '',
    roleData: [
      {
        id: '1',
        title: '普通用户',
      },
      {
        id: '2',
        title: '演示帐号',
      },
      {
        id: '3',
        title: '管理员',
      },
    ],
    form: {
      id: undefined,
      name: undefined,
      sex: undefined,
      card: undefined,
      phone: undefined,
      vtype: undefined,
      startTime: undefined,
      endTime: undefined,
    },
    rules: {
      phone: [{ required: true, message: '请输入', trigger: 'change' }],
      startTime: [{ required: true, message: '请输入', trigger: 'change' }],
      endTime: [{ required: true, message: '请输入', trigger: 'change' }],
      vtype: [{ required: true, message: '请选择', trigger: 'change' }],
    },
  });

  const myform = ref<FormInstance>();

  onMounted(() => {
    getVipList();
  });

  const getVipList = () => {
    data.loading = true;
    listApi({
      keyword: data.keyword,
    })
      .then((res) => {
        data.loading = false;
        console.log(res);
        res.data.forEach((item: any, index: any) => {
          item.index = index + 1;
        });
        data.vipList = res.data;
      })
      .catch((err) => {
        data.loading = false;
        console.log(err);
      });
  };

  const onSearchChange = (e: Event) => {
    data.keyword = e?.target?.value;
    console.log(data.keyword);
  };

  const onSearch = () => {
    getVipList();
  };

  const rowSelection = ref({
    onChange: (selectedRowKeys: (string | number)[], selectedRows: DataItem[]) => {
      console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
      data.selectedRowKeys = selectedRowKeys;
    },
  });

  const handleAdd = () => {
    resetModal();
    modal.visile = true;
    modal.editFlag = false;
    modal.title = '新增';
    // 重置
    for (const key in modal.form) {
      modal.form[key] = undefined;
    }
  };
  const handleEdit = (record: any) => {
    resetModal();
    modal.visile = true;
    modal.editFlag = true;
    modal.title = '编辑';
    // 重置
    for (const key in modal.form) {
      modal.form[key] = undefined;
    }
    for (const key in record) {
      modal.form[key] = record[key];
    }
  };


  const handleOk = () => {
    myform.value
      ?.validate()
      .then(() => {
        const formData = new FormData();
        if (modal.form.id) {
          formData.append('id', modal.form.id);
        }
        if (modal.form.name) {
          formData.append('name', modal.form.name);
        }
        if (modal.form.sex) {
          formData.append('sex', modal.form.sex);
        }
        if (modal.form.card) {
          formData.append('card', modal.form.card);
        }
        if (modal.form.phone) {
          formData.append('phone', modal.form.phone);
        }
        if (modal.form.vtype) {
          formData.append('vtype', modal.form.vtype);
        }
        if (modal.form.startTime) {
          formData.append('startTime', modal.form.startTime);
        }
        if (modal.form.endTime) {
          formData.append('endTime', modal.form.endTime);
        }
        if (modal.editFlag) {
          updateApi(formData)
            .then((res) => {
              hideModal();
              getVipList();
            })
            .catch((err) => {
              console.log(err);
              message.warn(err.msg || '操作失败');
            });
        } else {
          createApi(formData)
            .then((res) => {
              hideModal();
              getVipList();
            })
            .catch((err) => {
              console.log(err);
              message.warn(err.msg || '操作失败');
            });
        }
      })
      .catch((err) => {
        console.log('不能为空');
      });
  };
  const handleBatchDelete = () => {
    console.log(data.selectedRowKeys);
    if (data.selectedRowKeys.length <= 0) {
      console.log('hello');
      message.warn('请勾选删除项');
      return;
    }
    deleteApi({ ids: data.selectedRowKeys.join(',') })
      .then((res) => {
        message.success('删除成功');
        data.selectedRowKeys = [];
        getUserList();
      })
      .catch((err) => {
        message.warn(err.msg || "操作失败")
      });
  };
  const handleCancel = () => {
    hideModal();
  };

  // 恢复表单初始状态
  const resetModal = () => {
    myform.value?.resetFields();
  };

  // 关闭弹窗
  const hideModal = () => {
    modal.visile = false;
  };
</script>

<style scoped lang="less">
  .page-view {
    min-height: 100%;
    background: #fff;
    padding: 24px;
    display: flex;
    flex-direction: column;
  }

  .table-operations {
    margin-bottom: 16px;
    text-align: right;
  }

  .table-operations > button {
    margin-right: 8px;
  }
</style>
