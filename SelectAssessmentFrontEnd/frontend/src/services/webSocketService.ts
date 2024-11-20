import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

const URL = "http://localhost:8080/ws"

let client;
export const connect = (callbackFunction) => {
    client = new Client({
        webSocketFactory: () => new SockJS(URL),
        onConnect: () => {
            client.subscribe('/topic/invoices', invoices => callbackFunction(JSON.parse(invoices.body)))
        },
        onStompError: (err) => console.error("Error occurred in STOMP: " + err['headers']['message'])
    });
    client.activate();
}

export const disconnect = () => client ? client.deactivate() : null;

