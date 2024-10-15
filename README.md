
# Canva Connect API Java SDK


## Overview
API for building integrations with Canva via a REST api


### Example Client Initialization

```java
import com.canva.canvaconnectapi.Client;

Client client = Client
                .builder()
                .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                .withOauthAuthCode(System.getenv("API_TOKEN"))
                .build();
```

### SDK Usage 
 See [SDK Examples](SDK_EXAMPLES.md) for example usage of all SDK functionality