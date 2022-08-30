package ir.smartpath.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PersonDto {
    @NotNull
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String firstname;

    @ApiModelProperty(required = true, hidden = false)
    private String lastName;

    @ApiModelProperty(required = true, hidden = false)
    private Long nationalCode;

    @ApiModelProperty(required = true, hidden = false)
    private Integer age;

    @ApiModelProperty(required = true, hidden = false)
    private String email;

    @ApiModelProperty(required = true, hidden = false)
    private String password;
}
