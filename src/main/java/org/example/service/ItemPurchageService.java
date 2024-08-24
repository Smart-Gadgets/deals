package org.example.service;

import org.apache.coyote.BadRequestException;
import org.example.repository.DealsRepository;
import org.example.repository.TransactionRepo;
import org.example.repository.UserRePository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class ItemPurchageService {
    private final DealsRepository dealsRepository;
    private final TransactionRepo transactionRepo;
    private final UserRePository userRePository;

    @Autowired
    public ItemPurchageService(DealsRepository dealsRepository, TransactionRepo transactionRepo, UserRePository userRePository) {
        this.dealsRepository = dealsRepository;
        this.transactionRepo = transactionRepo;
        this.userRePository = userRePository;
    }

    public Boolean purchaseItemInDeal(Long itemId, String dealID, String userId) throws BadRequestException {
        if(Objects.isNull(userRePository.findDealByUserId(userId))) {
            throw new BadRequestException("not a valid User");
        }
        var deal = dealsRepository.findDealByDealId(dealID);
        var items = deal.getItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElse(null);
        if (Objects.isNull(items) || items.getCount() <1) {
            throw new BadRequestException("not a valid Item");
        }
        var deals = transactionRepo.findAllByDealIdAndUserId(dealID, userId);
        if (!ObjectUtils.isEmpty(deals)) {
            throw new BadRequestException("User already claimed the deal");
        }
        items.setCount(items.getCount() - 1);
        dealsRepository.save(deal);
        return true;
    }
}
