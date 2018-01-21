package  software.eng.project.bank.security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public enum AuthorityName {
    @JsonProperty("ROLE_USER")
    ROLE_USER,
    ROLE_ADMIN ,
    ROLE_STUFF


}