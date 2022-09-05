package ir.smartpath.Mapper;

import ir.smartpath.dto.PersonDTO;
import ir.smartpath.dto.RoleDTO;
import ir.smartpath.entity.Person;
import ir.smartpath.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole (RoleDTO roleDTO);

    RoleDTO toRoleDTO(Role role);

    List<RoleDTO> toRoleDTO(List<Role> roleList);

    List<Role> toRole(List<RoleDTO> roleDTOS);


}
