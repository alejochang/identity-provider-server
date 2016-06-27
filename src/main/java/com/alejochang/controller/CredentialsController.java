package com.alejochang.controller;

import com.alejochang.model.AuthToken;
import com.alejochang.model.User;
import com.alejochang.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@Api(value = "/auth", description = "Authentication API")
@RequestMapping(value = "/auth", produces = {APPLICATION_JSON_VALUE})
public class CredentialsController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "/login", notes = "Authenticates user")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Authorized"),
            @ApiResponse(code = 403, message = "Unauthorized")})
    @RequestMapping(value = "/login",
                    produces = {"application/json"},
                    consumes = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<AuthToken> login(@ApiParam(value = "User credentials", required = true) @RequestBody User user)throws NotFoundException {

        AuthToken token = userService.authenticate(user.getUsername(), user.getPassword());

        if(token!=null){
            return new ResponseEntity<AuthToken>(token, HttpStatus.OK);
        }else{
            return new ResponseEntity<AuthToken>(new AuthToken(null, null), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/logout",
                    produces = {"application/json"},
                    consumes = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Void> logout(@RequestBody AuthToken token) throws NotFoundException {
        userService.invalidateToken(token);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/validate/{appKey}",
            produces = {"application/json"},
            consumes = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> validateToken(@RequestBody AuthToken token, @PathVariable("appKey") Long appKey) throws NotFoundException {

        //check appKey
        return new ResponseEntity<Boolean>(userService.validateToken(token), HttpStatus.NO_CONTENT);
    }


}
