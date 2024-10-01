package ie.atu.yr4lab2buildingtwointeractingmicroservices;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull
    private long id;

    @NotBlank
    @Size(min = 2, max=20)
    private String name;

    @PositiveOrZero
    private double price;
}