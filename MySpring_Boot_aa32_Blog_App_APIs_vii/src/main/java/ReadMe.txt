  
   Steps to Implement JWT:
   
   * Add dependency (io.jsonwebtoken)
   * Create JWT authenticationEntryPoint implements AuthenticationEntryPoint
   * Create JWTTokenHelper
   * JwtAuthenticationFilter extends OnceRequestFilter:
      * Get jwt token from response
      * Validate token
      * Get user from token
      * Load user associated with token
      * Set spring security
   * Create JwtAuthResponse
   * Configure JWT in spring security config
   * Create login api to return token
   * Test the application
   
