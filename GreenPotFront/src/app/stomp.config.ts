import {RxStompConfig} from "@stomp/rx-stomp";

export const stompConfig: RxStompConfig = {
  brokerURL: 'ws://localhost:8080/message/get',
  connectHeaders: {
    Authorization: localStorage.getItem('access_token') as string,
  },
}
