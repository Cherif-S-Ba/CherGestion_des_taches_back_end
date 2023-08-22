package sn.sensoft.security

import grails.gorm.DetachedCriteria
import grails.rest.Resource
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
@Resource(formats = ['json','xml'])
class TacheUserRole implements Serializable {

	private static final long serialVersionUID = 1

	TacheUser tacheUser
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof TacheUserRole) {
			other.tacheUserId == tacheUser?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (tacheUser) {
            hashCode = HashCodeHelper.updateHash(hashCode, tacheUser.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static TacheUserRole get(long tacheUserId, long roleId) {
		criteriaFor(tacheUserId, roleId).get()
	}

	static boolean exists(long tacheUserId, long roleId) {
		criteriaFor(tacheUserId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long tacheUserId, long roleId) {
		TacheUserRole.where {
			tacheUser == TacheUser.load(tacheUserId) &&
			role == Role.load(roleId)
		}
	}

	static TacheUserRole create(TacheUser tacheUser, Role role, boolean flush = false) {
		def instance = new TacheUserRole(tacheUser: tacheUser, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(TacheUser u, Role r) {
		if (u != null && r != null) {
			TacheUserRole.where { tacheUser == u && role == r }.deleteAll()
		}
	}

	static int removeAll(TacheUser u) {
		u == null ? 0 : TacheUserRole.where { tacheUser == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : TacheUserRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    tacheUser nullable: false
		role nullable: false, validator: { Role r, TacheUserRole ur ->
			if (ur.tacheUser?.id) {
				if (TacheUserRole.exists(ur.tacheUser.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['tacheUser', 'role']
		version false
	}
}
