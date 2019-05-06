# gRPC client/server communication tests v.1.0.0

[![Build Status](https://travis-ci.org/lucapompei/gRPC.svg?branch=master)](https://travis-ci.org/lucapompei/gRPC) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

=============================

This project shows some gRPC examples.


Summary features
-------

- A simple gRPC client/server communication without authentication.
- A gRPC client/server communication based on TLS authentication mechanism.


Usage
-------


- Define all .proto files in src/main/proto

- Compile .proto files through maven plugins via: `mvn clean install`

- Take compiled .proto files in target/protobuf


License
-------

  Copyright (C) 2019 lucapompei
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
