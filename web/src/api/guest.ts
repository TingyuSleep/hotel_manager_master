// 权限问题后期增加
import { get, post } from '/@/utils/http/axios';
import { UserState } from '/@/store/modules/guest/types';
// import axios from 'axios';
enum URL {
  login = '/api/guest/login',
  guestList = '/api/guest/list',
  detail = '/api/guest/detail',
  create = '/api/guest/create',
  update = '/api/guest/update',
  delete = '/api/guest/delete',
  guestLogin = '/api/guest/guestLogin',
  guestRegister = '/api/guest/guestRegister',
  updateguestPwd = '/api/guest/updatePwd',
  updateguestInfo = '/api/guest/updateguestInfo',
}
interface LoginRes {
  token: string;
}

export interface LoginData {
  guestname: string;
  password: string;
}

const loginApi = async (data: LoginData) =>
  post<any>({ url: URL.login, data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const listApi = async (params: any) => get<any>({ url: URL.guestList, params: params, data: {}, headers: {} });
const detailApi = async (params: any) => get<any>({ url: URL.detail, params: params, data: {}, headers: {} });
const createApi = async (data: any) =>
  post<any>({ url: URL.create, params: {}, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const updateApi = async (data: any) =>
  post<any>({ url: URL.update, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const deleteApi = async (params: any) => post<any>({ url: URL.delete, params: params, headers: {} });
const guestLoginApi = async (data: LoginData) =>
  post<any>({ url: URL.guestLogin, data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const guestRegisterApi = async (data: any) =>
  post<any>({ url: URL.guestRegister, params: {}, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });
const updateguestPwdApi = async (params: any) => post<any>({ url: URL.updateguestPwd, params: params });
const updateguestInfoApi = async (data: any) =>
  post<any>({ url: URL.updateguestInfo, data: data, headers: { 'Content-Type': 'multipart/form-data;charset=utf-8' } });

export {
  loginApi,
  listApi,
  detailApi,
  createApi,
  updateApi,
  deleteApi,
  guestLoginApi,
  guestRegisterApi,
  updateguestPwdApi,
  updateguestInfoApi,
};
