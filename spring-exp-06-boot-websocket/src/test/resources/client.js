let url = 'ws://' + window.location.host + '/marco';
let sock = new WebSocket(url);

sock.onopen = function () {
    console.log('Opening');
    sayMarco();
};

sock.onmessage = function (e) {
    console.log('Received message: ', e.data);
    setTimeout(function () {
        sayMarco()
    }, 2000);
};

sock.onclose = function () {
    console.log('Closing');
};

function sayMarco() {
    console.log('Sending message: Marco!');
    sock.send("Marco!");
}