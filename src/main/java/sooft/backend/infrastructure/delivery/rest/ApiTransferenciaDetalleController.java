package sooft.backend.infrastructure.delivery.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sooft.backend.business.casouso.apitransaccion.ApiTransaccionDetalleService;
import sooft.backend.domain.model.ApiTransaccionDetalle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ApiTransferenciaDetalle/")
public class ApiTransferenciaDetalleController {
    @Autowired
    private ApiTransaccionDetalleService apiTransaccionDetalleService;

    // insert a apiTransaccionDetalle into database
    @ApiOperation(value = "Alta de apiTransaccionDetalle", notes = "Alta de apiTransaccionDetalle")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<ApiTransaccionDetalle> saveapiTransaccionDetalle(@RequestBody ApiTransaccionDetalle apiTransaccionDetalle) {
        apiTransaccionDetalle.setId(0L);
        ApiTransaccionDetalle savedapiTransaccionDetalle = apiTransaccionDetalleService.save(apiTransaccionDetalle);
        return new ResponseEntity<>(savedapiTransaccionDetalle, HttpStatus.CREATED);
    }

    //get a single apiTransaccionDetalle by its id
    @ApiOperation(value = "Buscar de apiTransaccionDetalle por Id ", notes = "Buscar de apiTransaccionDetalle por Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<ApiTransaccionDetalle> getapiTransaccionDetalle(@RequestParam(name = "id") long id) {
        Optional<ApiTransaccionDetalle> apiTransaccionDetalle = apiTransaccionDetalleService.findById(id);
        return new ResponseEntity<ApiTransaccionDetalle>(apiTransaccionDetalle.orElse(null), HttpStatus.OK);
    }

    //get all the apiTransaccionDetalle in the table in our database
    @ApiOperation(value = "Buscar de toda la apiTransaccionDetalle . ", notes = "Buscar toda la apiTransaccionDetalle")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "apiTransaccionDetalles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<ApiTransaccionDetalle> getapiTransaccionDetalles() {
        return apiTransaccionDetalleService.findAll();
    }

    // delete an existing apiTransaccionDetalle in the database
    @ApiOperation(value = "Borrar  apiTransaccionDetalle por Id . ", notes = "Borrar apiTransaccionDetalle por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<ApiTransaccionDetalle> deleteapiTransaccionDetalle(@RequestParam(name = "id") long id) {
        ApiTransaccionDetalle deleteduser = apiTransaccionDetalleService.findById(id).orElse(null);
        apiTransaccionDetalleService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }
}
