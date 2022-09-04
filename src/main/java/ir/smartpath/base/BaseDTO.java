package ir.smartpath.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BaseDTO {
    @NotNull
    @ApiModelProperty(required = false, hidden = true)
    private Long id;


    @ApiModelProperty(required = false, hidden = true)
    private Date createdDate;
/*
    @ApiModelProperty(required = false, hidden = true)
    private Integer version;*/


/*
    @ApiModelProperty(required = false, hidden = true)
    private String createdBy;

    @ApiModelProperty(required = false, hidden = true)
    private Date lastModifiedDate;

    @ApiModelProperty(required = false, hidden = true)
    private String lastModifiedBy;

*/

}
