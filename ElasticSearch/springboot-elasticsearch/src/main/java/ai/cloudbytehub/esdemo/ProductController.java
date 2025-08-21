package ai.cloudbytehub.esdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ElasticsearchClient esClient;

    public ProductController(ElasticsearchClient esClient) {
        this.esClient = esClient;
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) throws IOException {
        IndexResponse response = esClient.index(i -> i
            .index("products")
            .id(product.getName())
            .document(product)
        );
        return "Indexed with id: " + response.id();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) throws IOException {
        SearchResponse<Product> response = esClient.search(s -> s
                .index("products")
                .query(q -> q.match(m -> m.field("name").query(name))),
            Product.class
        );
        List<Product> results = new ArrayList<>();
        for (Hit<Product> hit : response.hits().hits()) {
            results.add(hit.source());
        }
        return results;
    }
}
