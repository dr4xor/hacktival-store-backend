var stompClient = null;

function connect() {
  var socket = new SockJS("http://localhost:8080/discovery-store");
  var stompClient = Stomp.over(socket);
  stompClient.connect({}, function(frame) {
    // subscribe to the /topic/message endpoint
    stompClient.subscribe("/discovery-store", function(data) {
      console.log(data);
    });
  });
}

function disconnect() {
  if (ws != null) {
    ws.close();
  }
  //setConnected(false);
  console.log("Disconnected");
}

function sendName() {
  console.log($("#appId").val());
  var value = {
    name: $("#appId").val()
  };
  ws.send(value);
}

function showGreeting(message) {
  $("#greetings").append(" " + message + "");
}

$(function() {
  $("form").on("submit", function(e) {
    e.preventDefault();
  });
  $("#connect").click(function() {
    connect();
  });
  $("#disconnect").click(function() {
    disconnect();
  });
  $("#send").click(function() {
    sendName();
  });
});
