import {StompService} from "./stomp.service";
import {stompConfig} from "../stomp.config";

export function stompServiceFactory(){
  const rxStomp = new StompService();
  rxStomp.configure(stompConfig);
  rxStomp.activate();
  return rxStomp;
}
