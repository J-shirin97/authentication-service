package ir.smartpath.dto;

import io.swagger.annotations.ApiModelProperty;
import ir.smartpath.entity.enumuration.Gender;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PersonDto {
    @NotNull
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String firstName;

    @ApiModelProperty(required = true, hidden = false)
    private String lastName;

    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = true, hidden = false)
    private Integer age;

    @ApiModelProperty(required = true, hidden = false)
    private Gender gender;

    @ApiModelProperty(required = true, hidden = false)
    private String email;

    @ApiModelProperty(required = true, hidden = false)
    private String password;
}
