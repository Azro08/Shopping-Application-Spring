package com.azrosk.order_service.service;

import com.azrosk.order_service.dto.OrderLineItemsDto;
import com.azrosk.order_service.dto.OrderRequest;
import com.azrosk.order_service.model.Order;
import com.azrosk.order_service.model.OrderLineItems;
import com.azrosk.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(this::mapToOrderLineItems).toList();
        Order order = Order.builder()
                .orderLineItemsList(orderLineItems)
                .build();

        orderRepository.save(order);

    }

    private OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .skuCode(orderLineItemsDto.getSkuCode())
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }

}
