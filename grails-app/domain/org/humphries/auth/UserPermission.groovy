package org.humphries.auth

import org.apache.commons.lang.builder.HashCodeBuilder

class UserPermission implements Serializable {

	User user
	Permission permission

	boolean equals(other) {
		if (!(other instanceof UserPermission)) {
			return false
		}

		other.user?.id == user?.id &&
			other.permission?.id == permission?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (permission) builder.append(permission.id)
		builder.toHashCode()
	}

	static UserPermission get(long userId, long permissionId) {
		find 'from UserPermission where user.id=:userId and permission.id=:permissionId',
			[userId: userId, permissionId: permissionId]
	}

	static UserPermission create(User user, Permission permission, boolean flush = false) {
		new UserPermission(user: user, permission: permission).save(flush: flush, insert: true)
	}

	static boolean remove(User user, Permission permission, boolean flush = false) {
		UserPermission instance = UserPermission.findByUserAndPermission(user, permission)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM UserPermission WHERE user=:user', [user: user]
	}

	static void removeAll(Permission permission) {
		executeUpdate 'DELETE FROM UserPermission WHERE permission=:permission', [permission: permission]
	}

	static mapping = {
		id composite: ['permission', 'user']
		version false
	}
}
