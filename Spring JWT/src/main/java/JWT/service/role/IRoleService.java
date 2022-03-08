package JWT.service.role;

import JWT.model.Role;
import JWT.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
