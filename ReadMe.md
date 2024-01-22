# Usage

This module demonstrates how we can leverage mockserver-netty to create a virtual server and have it return the data that we want so that it can be leveraged by any E2E test frameworks which sources data from REST calls

## How can we see this in action
Run Server.java first which starts the mock server with a defined expectation

Run Client.java which will call a GET request on this server and receive the defined response


