package ir.smartpath.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BaseDTO {
    @NotNull
    @ApiModelProperty(required = false, hidden = true)
    private Long id;
}
