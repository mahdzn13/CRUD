# CRUD
Realm:
`<Realm className="org.apache.catalina.realm.JDBCRealm"
			driverName="com.mysql.jdbc.Driver"
			connectionURL="jdbc:mysql://SERVERIP/dwes?user=USER&amp;password=PASS"
			userTable="users" userNameCol="user_name" userCredCol="user_pass"
			userRoleTable="user_roles" roleNameCol="role_name"/>
</Realm>`


Link DB connector for tomcat:
[MySQL connector](https://dev.mysql.com/downloads/connector/j/)


Put on /lib of tomcat
> tomcat/lib
