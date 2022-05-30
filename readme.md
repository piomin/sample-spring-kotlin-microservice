## Kotlin Microservice with Spring Boot  [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

Detailed description can be found here: [Kotlin Microservice with Spring Boot](https://piotrminkowski.com/2019/01/15/kotlin-microservice-with-spring-boot/)



openssl req -x509 -sha256 -nodes -days 365 -newkey rsa:2048 -subj '/O=emarq830 Inc./CN=emarq830.eastus.aroapp.io' -keyout emarq830.eastus.aroapp.io.key -out emarq830.eastus.aroapp.io.crt
openssl req -out sample-spring-boot.emarq830.eastus.aroapp.io.csr -newkey rsa:2048 -nodes -keyout sample-spring-boot.emarq830.eastus.aroapp.io.key -subj "/CN=sample-spring-boot.apps.emarq830.eastus.aroapp.io/O=httpbin organization"
openssl x509 -req -sha256 -days 365 -CA emarq830.eastus.aroapp.io.crt -CAkey emarq830.eastus.aroapp.io.key -set_serial 0 -in sample-spring-boot.emarq830.eastus.aroapp.io.csr -out sample-spring-boot.emarq830.eastus.aroapp.io.crt
kubectl create -n istio-system secret tls sample-spring-boot-credential --key=sample-spring-boot.emarq830.eastus.aroapp.io.key --cert=sample-spring-boot.emarq830.eastus.aroapp.io.crt

openssl pkcs12 -export -in [path/to/certificate] -inkey [path/to/privatekey] -certfile [path/to/ca/certificate ] -out keystore.p12 -name [alias-name]
openssl pkcs12 -export -in sample-spring-boot.emarq830.eastus.aroapp.io.crt -inkey sample-spring-boot.emarq830.eastus.aroapp.io.key -certfile emarq830.eastus.aroapp.io.crt -name sample-spring-boot -out sample-spring-boot.emarq830.eastus.aroapp.io.p12
keytool -importkeystore -deststorepass 123456 -destkeystore sample-spring-boot.emarq830.eastus.aroapp.io.jks -srckeystore sample-spring-boot.emarq830.eastus.aroapp.io.p12 -srcstoretype PKCS12
keytool -import -alias sample-spring-boot -trustcacerts -file emarq830.eastus.aroapp.io.crt -keystore sample-spring-boot.emarq830.eastus.aroapp.io.jks