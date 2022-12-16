import {RxStompConfig} from "@stomp/rx-stomp";

export const stompConfig: RxStompConfig = {
  brokerURL: 'ws://127.0.0.1:8080/message/get',

  // connectHeaders: {
  //   login: 'guest',
  //   passcode: 'guest',
  // },
}
