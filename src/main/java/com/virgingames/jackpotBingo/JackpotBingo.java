package com.virgingames.jackpotBingo;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class JackpotBingo {

    @Step("Getting jackpot bingo information")
    public ValidatableResponse getJackpotBingo() {
        return SerenityRest.given().log().all()
                .basePath(Path.getApi)
                .when()
                .get(EndPoints.jackpotBingo)
                .then();
    }
}
