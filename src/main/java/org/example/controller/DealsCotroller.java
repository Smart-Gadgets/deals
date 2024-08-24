package org.example.controller;

import org.apache.coyote.BadRequestException;
import org.example.model.Deal;
import org.example.service.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class DealsCotroller {
    private final DealsService dealsService;

    @Autowired
    public DealsCotroller(DealsService dealsService) {
        this.dealsService = dealsService;
    }

    @PostMapping(path = "/create_deal")
    public HttpEntity<Deal> createDeal(HttpEntity<Deal> deals) throws BadRequestException {

        return dealsService.createAndValidateDeal(deals.getBody());
    }

    @PutMapping (path = "/update_deal")
    public HttpEntity<Deal> updateDeal(HttpEntity<Deal> deals) throws BadRequestException {
        return dealsService.updateAndValidateDeal(deals.getBody());
    }

    @GetMapping(path = "/end_deal/{dealId}")
    public HttpEntity<Deal> createDeal(@PathVariable String dealId) throws BadRequestException {
        return dealsService.endDeal(dealId);
    }
}
