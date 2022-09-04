package ir.smartpath.dto;

import io.swagger.annotations.ApiModelProperty;
import ir.smartpath.base.BaseDTO;
import lombok.Data;

@Data
public class LoginDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = true, hidden = false)
    private String password;
}
