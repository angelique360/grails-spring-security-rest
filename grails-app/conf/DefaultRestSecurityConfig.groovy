import javax.servlet.http.HttpServletResponse

security {

    rest {

        active = true

        login {
            enabled = true
            endpointUrl = '/api/login'
            usernameParameter = 'username'
            passwordParameter = 'password'
            usernamePropertyName = 'username'
            passwordPropertyName = 'password'
            failureStatusCode = HttpServletResponse.SC_UNAUTHORIZED    //401
            useRequestParamsCredentials = true
            useJsonCredentials = false
        }

        logout {
            endpointUrl = '/api/logout'
        }

        token {

            generation {
                useSecureRandom = true
                useUUID = false
            }

            storage {
                useGorm = false
                useMemcached = false
                useGrailsCache = false

                gorm {
                    tokenDomainClassName = null
                    tokenValuePropertyName = 'tokenValue'
                    usernamePropertyName = 'username'
                }

                memcached {
                    hosts = 'localhost:11211'
                    username = ''
                    password = ''

                    expiration = 3600
                }

            }

            validation {
                enabled = true
                headerName = 'X-Auth-Token'
                endpointUrl = '/api/validate'
            }

            rendering {
                usernamePropertyName = 'username'
                tokenPropertyName = 'token'
                authoritiesPropertyName = 'roles'
            }
        }
    }
}