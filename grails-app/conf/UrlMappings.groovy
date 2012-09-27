class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/mainPage")
        "/admin"(view:"/index")
		"500"(view:'/error')
	}
}
