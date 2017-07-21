# Introduction

A playground for experimentation with JMS based communication. There are five modules simulating the communication with two external systems with their own separately managed jms queues (via two ActiveMQ brokers).

# Overview
![JMS communication overview](/images/jmsOverview.png)

# Projects

## Elisa (demo-elisa-sender)
Represents the system that produces the data. It sends the data to the elisa-mailbox queue, that is managed by the elisa broker. New data is produced and sent every 3 seconds.

## Elisa JMS broker
An ActiveMQ broker that manages the elisa-mailbox queue.

## Mobility service
The mobility service listens for messages on the elisa-mailbox. The messages could be processed in some way before the processed data is sent to the wms-mailbox queue.

## WMS JMS broker
An ActiveMQ broker that manages the wms-mailbox queue.

## WMS
Listens for new messages on the wms-mailbox queue.
