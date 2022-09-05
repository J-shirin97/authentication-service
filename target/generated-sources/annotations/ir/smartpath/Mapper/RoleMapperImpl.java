package ir.smartpath.Mapper;

import ir.smartpath.dto.RoleDTO;
import ir.smartpath.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-05T13:54:12+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setRole( roleDTO.getRole() );

        return role;
    }

    @Override
    public RoleDTO toRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRole( role.getRole() );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toRoleDTO(List<Role> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roleList.size() );
        for ( Role role : roleList ) {
            list.add( toRoleDTO( role ) );
        }

        return list;
    }

    @Override
    public List<Role> toRole(List<RoleDTO> roleDTOS) {
        if ( roleDTOS == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleDTOS.size() );
        for ( RoleDTO roleDTO : roleDTOS ) {
            list.add( toRole( roleDTO ) );
        }

        return list;
    }
}
