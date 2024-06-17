// 权限问题后期增加
import { get, post } from '/@/utils/http/axios';
import { UserState } from '/@/store/modules/user/types';
// import axios from 'axios';
enum URL {
  login = '/api/vip/login',
  vipList = '/api/vip/list',
  detail = '/api/vip/detail',
  create = '/api/vip/create',
  update = '/api/vip/update',
  delete = '/api/vip/delete',
}
interface LoginRes {
  token: string;
}

export interface LoginData {
  vipname: string;
  password: string;
}

const loginApi = async (data: LoginData) =>
  post<any>({ url: URL.login, data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const listApi = async (params: any) => get<any>({ url: URL.vipList, params: params, data: {}, headers: {} });
const detailApi = async (params: any) => get<any>({ url: URL.detail, params: params, data: {}, headers: {} });
const createApi = async (data: any) =>
  post<any>({ url: URL.create, params: {}, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const updateApi = async (data: any) =>
  post<any>({ url: URL.update, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const deleteApi = async (params: any) => post<any>({ url: URL.delete, params: params, headers: {} });

export { loginApi, listApi, detailApi, createApi, updateApi, deleteApi };
