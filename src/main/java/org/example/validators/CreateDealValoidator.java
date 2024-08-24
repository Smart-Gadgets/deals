package org.example.validators;

import org.apache.coyote.BadRequestException;
import org.example.model.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateDealValoidator {

    public void validateDeal(Deal deal) throws BadRequestException {
        if(Objects.isNull(deal)) {
            throw new BadRequestException("deal cant be null");
        }
        if (Objects.isNull(deal.getItems())) {
            throw new BadRequestException("Atleast 1 item is required to create the deal");
        }
        if (Objects.isNull(deal.getEndTime())) {
            throw new BadRequestException("EndTime is required to create the deal");
        }

    }
}
