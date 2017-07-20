# Introduction

A playground for experimentation with JMS based comunication. The repository houses a few different modules, each representing a different participant in the messaging process.

# Projects

## demo-broker

Encapsulates the JMS provider.
* It's a simple spring boot application that depends on the ActiveMQ broker.
* It only manages the JMS queues/topics and doesn't produce or consume any messages.
* Can be replaced by any JMS broker. It's a separate module only because it's convenient to manage it from the IDE the same way as the other modules and simplifies the setup.

## demo-receiver

A simple message consumer.
* Receives messages from the "mailbox" destination (queue)
* Uses jackson to convert the message payload from json to an instance of com.example.demoreceiver.Email.

## demo-sender
A simple message producer.
* Sends messages to the "mailbox" destination (queue)
* Uses jackson to convert the message payload to json from an instance of com.example.demosender.Email.
* Uses a scheduler to periodically send the same message
