package org.example.validators;

import org.apache.coyote.BadRequestException;
import org.example.model.Deal;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UpdateDealValoidator {

    public void validateDeal(Deal deal) throws BadRequestException {
        if(Objects.isNull(deal)) {
            throw new BadRequestException("deal cant be null");
        }
        if (Objects.isNull(deal.getItems()) && Objects.isNull(deal.getEndTime())){
            throw new BadRequestException("EndTime or atleast 1 item  required to update the deal");
        }
    }
}
