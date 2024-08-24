package org.example.service;

import org.apache.coyote.BadRequestException;
import org.example.model.Deal;
import org.example.repository.DealsRepository;
import org.example.validators.CreateDealValoidator;
import org.example.validators.UpdateDealValoidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DealsService {

    private final CreateDealValoidator createDealValoidator;
    private final UpdateDealValoidator updateDealValoidator;
    private final DealsRepository dealsRepository;

    @Autowired
    public DealsService(CreateDealValoidator createDealValoidator, UpdateDealValoidator updateDealValoidator, DealsRepository dealsRepository) {
        this.createDealValoidator = createDealValoidator;
        this.updateDealValoidator = updateDealValoidator;
        this.dealsRepository = dealsRepository;
    }

    public ResponseEntity<Deal> createAndValidateDeal(Deal deal) throws BadRequestException {
        createDealValoidator.validateDeal(deal);
        dealsRepository.save(deal);
        return new ResponseEntity<Deal>(deal, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<Deal> updateAndValidateDeal(Deal deal) throws BadRequestException {
        updateDealValoidator.validateDeal(deal);
        dealsRepository.save(deal);
        return new ResponseEntity<Deal>(deal, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<Deal> endDeal(String dealID) throws BadRequestException {
        var deal = dealsRepository.findDealByDealId(dealID);
        deal.setEndTime(new Date());
        dealsRepository.save(deal);
        return new ResponseEntity<>(deal, HttpStatusCode.valueOf(200));
    }
}
