package org.example.controller;

import org.apache.coyote.BadRequestException;
import org.example.model.CliamRe;
import org.example.service.ItemPurchageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemCotroller {

    private  final  ItemPurchageService itemPurchageService;

    @Autowired
    public ItemCotroller(ItemPurchageService itemPurchageService) {
        this.itemPurchageService = itemPurchageService;
    }

    @PostMapping(path = "/claim_deal")
    public Boolean createDeal(HttpEntity<CliamRe> claim) throws BadRequestException {
        var req= claim.getBody();
        return itemPurchageService.purchaseItemInDeal(req.getItemId(),
                req.getDealId(), req.getUserId());
    }
}
