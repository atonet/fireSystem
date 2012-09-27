dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = "net.sf.ehcache.hibernate.EhCacheProvider"
}

// environment specific settings
environments {
    development {
		    dataSource {
                dbCreate = "update" // one of 'create', 'create-drop','update'
                url = "jdbc:mysql://192.168.1.41:3306/firesystem_development?useUnicode=true&characterEncoding=UTF-8"
                username = "ole"
                password = "ole"
		    }
	  }
	  test {
		    dataSource {
                dbCreate = "update" // one of 'create', 'create-drop','update'
                url = "jdbc:mysql://192.168.1.41:3306/firesystem_development?useUnicode=true&characterEncoding=UTF-8"
                username = "ole"
                password = "ole"
		    }
	  }
	  production {
          dataSource {
              dbCreate = "update" // one of 'create', 'create-drop','update'
              url = "jdbc:mysql://192.168.1.41:3306/firesystem_development?useUnicode=true&characterEncoding=UTF-8"
              username = "ole"
              password = "ole"
          }
	  }
}