package hello.sns.service;

import hello.sns.entity.category.Category;
import hello.sns.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategory(String name) {

        Category category = categoryRepository.findByName(name).orElseGet(
                ()-> categoryRepository.save(new Category(name))
        );
        return category;
    }
}
