# helidon-microframework-example
[![Build Status](https://travis-ci.org/gregwhitaker/helidon-microframework-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/helidon-microframework-example)

An example of creating a microservice using Oracle's [Helidon Microframework](https://helidon.io/#/).

## Running the Example
1. Run the following command to start the application:

        ./gradlew run
        
    If the server starts successfully you will see something similar to the following in the console:
    
        [DEBUG] (main) Using Console logging
        2018.10.12 18:46:34 INFO io.netty.util.internal.PlatformDependent Thread[main,5,main]: Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.
        2018.10.12 18:46:35 INFO io.helidon.webserver.netty.NettyWebServer Thread[nioEventLoopGroup-2-1,10,main]: Channel '@default' started: [id: 0x8bc5367d, L:/0:0:0:0:0:0:0:0:8080]
        Server running: http://localhost:8080
    
2. Run the following command to query the `/hello` endpoint:

        curl -X GET http://localhost:8080/hello
        
    If successful, you will see the following response:
   
        {"message":"Hello, World!"}
        
3. Run the following command to query the `/hello/{name}` endpoint:

       curl -X GET http://localhost:8080/hello/George
       
   If successful, you will see the following response:
  
       {"message":"Hello, George!"}

## Bugs and Feedback
For bugs, questions and discussions please use the [Github Issues](https://github.com/gregwhitaker/helidon-microframework-example/issues).

## License
Copyright 2018 Greg Whitaker

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.