package com.almiraquino.brewer.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.almiraquino.brewer.model.Beer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class BeersControllerTest {

    BeersController controller = new BeersController();

    @Test
    void newBeer() {
        // given
        Beer beer = new Beer();
        beer.setName("Guinness");
        Model model = new ExtendedModelMap();

        // when
        String viewName = controller.newBeer(beer, model);

        // then
        assertEquals("beer/add-beer", viewName);

        // and
        Object beerAttribute = model.asMap().get("beer");
        assertInstanceOf(Beer.class, beerAttribute);
        assertEquals("Guinness", ((Beer) beerAttribute).getName());

        // and 
        assertEquals(3, controller.beers.size());
        assertEquals(beerAttribute, controller.beers.get(2));
    }

    @ParameterizedTest(name = "{index} when the sort is \"{0}\" then the expected order is {1}")
    @CsvSource({
        "'','Guinness, Coors Light'",
        "'byName','Coors Light, Guinness'",
    })
    void list(String sort, String expectedOrder) {
        // given
        Model model = new ExtendedModelMap();

        // when
        String viewName = controller.list(sort, model);

        // then
        assertEquals("beer/list", viewName);

        // and
        Object beerList = model.asMap().get("beers");
        assertInstanceOf(List.class, beerList);
        assertEquals(expectedOrder, ((List<Beer>) beerList).stream()
            .map(Beer::getName)
            .collect(Collectors.joining(", ")));

    }

}