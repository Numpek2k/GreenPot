-- Insert roles into the ROLE table
INSERT INTO ROLE (id, name) VALUES
                                (1, 'USER'),
                                (2, 'ADMIN') ON CONFLICT (id) DO NOTHING;

-- Insert main categories into the main_category table
INSERT INTO main_category (id, name)
VALUES
    (1, 'Perennials'),
    (2, 'Annuals'),
    (3, 'Herbs'),
    (4, 'Shrubs'),
    (5, 'Trees'),
    (6, 'Climbers or Vines'),
    (7, 'Bulbs'),
    (8, 'Roses'),
    (9, 'Succulents'),
    (10, 'Fruit and Vegetable Plants') ON CONFLICT (id) DO NOTHING;

-- Insert plant subcategories into the plant_sub_category table
INSERT INTO sub_category (id, name)
VALUES
    (1, 'Dry Soil'),
    (2, 'Sandy Soil'),
    (3, 'Clay Soil'),
    (4, 'Loamy Soil'),
    (5, 'Well-Drained Soil'),
    (6, 'Acidic Soil'),
    (7, 'Alkaline Soil'),
    (8, 'Full Sun'),
    (9, 'Partial Sun'),
    (10, 'Partial Shade'),
    (11, 'Full Shade'),
    (12, 'Spring Blooms'),
    (13, 'Summer Blooms'),
    (14, 'Fall Blooms'),
    (15, 'Year-Round Blooms'),
    (16, 'Ground Cover'),
    (17, 'Low-Growing'),
    (18, 'Medium Height'),
    (19, 'Tall'),
    (20, 'Climbing Vines'),
    (21, 'Drought-Tolerant'),
    (22, 'Low Water Requirements'),
    (23, 'Moderate Watering'),
    (24, 'High Water Needs'),
    (25, 'Red Blooms'),
    (26, 'Pink Blooms'),
    (27, 'Blue Blooms'),
    (28, 'White Blooms'),
    (29, 'Yellow Blooms'),
    (30, 'Purple Blooms'),
    (31, 'Multicolored Blooms'),
    (32, 'Fragrant Blooms'),
    (33, 'Non-Fragrant Blooms'),
    (34, 'Butterfly-Friendly'),
    (35, 'Bee-Pollinator'),
    (36, 'Bird Attractor'),
    (37, 'Culinary Herbs'),
    (38, 'Fruits'),
    (39, 'Vegetables'),
    (40, 'Native to Your Region') ON CONFLICT (id) DO NOTHING;

-- Insert events into the event table
INSERT INTO event (id, name)
VALUES
    (1, 'Planting'),
    (2, 'Replanting'),
    (3, 'Watering'),
    (4, 'Fertilization'),
    (5, 'Pruning'),
    (6, 'Pest Control'),
    (7, 'Harvesting'),
    (8, 'Transplanting'),
    (9, 'Mulching'),
    (10, 'Deadheading'),
    (11, 'Staking'),
    (12, 'Thinning'),
    (13, 'Weeding'),
    (14, 'Propagation'),
    (15, 'Soil Testing'),
    (16, 'Composting'),
    (17, 'Disease Control'),
    (18, 'Aeration'),
    (19, 'Misting'),
    (20, 'Training (for climbing plants)'),
    (21, 'Grafting'),
    (22, 'Harden Off (for seedlings)'),
    (23, 'Division (for perennials)'),
    (24, 'Repotting (for container plants)'),
    (25, 'Support Installation'),
    (26, 'Lawn Mowing (for lawns)') ON CONFLICT (id) DO NOTHING;

-- Insert user data with id and password values
INSERT INTO "user" (id, name, surname, email, description, role_id, password) values
    (1, 'Birch', 'Babber', 'bbabber0@lulu.com', 'Diverse zero defect adapter', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (2, 'Jozef', 'Housego', 'jhousego1@bloglovin.com', 'Innovative fault-tolerant Graphical User Interface', 2, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (3, 'Garrett', 'Hoggan', 'ghoggan2@springer.com', 'Managed 4th generation standardization', 2, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (4, 'Bari', 'Lutzmann', 'blutzmann3@hatena.ne.jp', 'Ameliorated discrete archive', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (5, 'Omar', 'Weaving', 'oweaving4@telegraph.co.uk', 'Function-based mobile archive', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (6, 'Gratiana', 'Everiss', 'geveriss5@sun.com', 'Multi-layered fault-tolerant extranet', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (7, 'Renato', 'Lownes', 'rlownes6@vistaprint.com', 'Organic discrete interface', 2, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (8, 'Fredra', 'Stirtle', 'fstirtle7@aboutads.info', 'Reactive intermediate product', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (9, 'Walther', 'Watson-Brown', 'wwatsonbrown8@latimes.com', 'Vision-oriented bottom-line strategy', 2, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq'),
    (10, 'Salvidor', 'Tavener', 'stavener9@senate.gov', 'Centralized modular middleware', 1, '$2a$10$WufSKO0yffnT9Y4KSsI/TOta84xV9D1GlXG2lc6Qt7EwdaWAzkzSq') ON CONFLICT (id) DO NOTHING;;


INSERT INTO plant (id, "date", description, growing, name, planting, requirements, author, category_id)
VALUES
    (1, '2023-01-10', 'Lavender (Lavandula) is a beautiful perennial herb known for its aromatic, purple blooms. It has a slow growth rate and is a favorite for gardens and herbal uses. Lavender thrives in full sun and well-drained soil, making it a delightful addition to your garden.', 'Lavender is known for its slow growth, requiring minimal maintenance. Regular pruning can help maintain its shape and encourage more blooms.', 'Lavender', 'Plant lavender in the spring when the soil has warmed up. It prefers well-drained soil and full sun exposure.', 'Lavender plants require full sun, well-drained soil, and occasional pruning to thrive. They are drought-tolerant once established.', 1, 1),
    (2, '2023-02-15', 'Scarlet Sage (Salvia coccinea) is an annual flowering plant with vibrant red flowers. It grows quickly and adds a splash of color to any garden. Scarlet Sage prefers full sun and regular watering.', 'Scarlet Sage is a fast-growing annual. Deadheading spent blooms can encourage continuous flowering throughout the growing season.', 'Scarlet Sage', 'Plant Scarlet Sage in the spring for a summer display of red blooms. It requires full sun and regular watering to keep the soil consistently moist.', 'Scarlet Sage thrives in full sun and well-drained soil with regular watering to maintain soil moisture.', 2, 2),
    (3, '2023-03-20', 'Basil is a popular culinary herb known for its aromatic leaves and versatile use in cooking. It has moderate growth and is a must-have in any herb garden. Basil prefers partial sun and regular watering.', 'Basil has a moderate growth rate and benefits from frequent harvesting to encourage bushier growth and prevent flowering.', 'Basil', 'Plant basil in the spring in well-drained soil with partial sun exposure. It requires regular watering to keep the soil consistently moist.', 'Basil needs partial sun, well-drained soil, and consistent moisture. Harvesting leaves regularly can promote healthy growth.', 3, 3),
    (4, '2023-04-25', 'Mock Orange (Philadelphus coronarius) is a deciduous shrub with fragrant white blossoms. It has a moderate growth rate and adds a delightful aroma to your garden. Mock Orange prefers full sun to partial shade and well-drained soil.', 'Mock Orange has a moderate growth rate. Pruning after flowering helps maintain its shape and encourage new growth for the next season.', 'Mock Orange', 'Plant Mock Orange in the spring in well-drained soil with full sun to partial shade exposure. Regular pruning after flowering can keep it healthy and shapely.', 'Mock Orange thrives in well-drained soil with full sun to partial shade exposure. The fragrant white blossoms attract pollinators.', 4, 4),
    (5, '2023-05-30', 'Pine trees are tall evergreen conifers known for their needle-like leaves. They have a slow growth rate and can become majestic additions to the landscape. Pine trees prefer full sun and adapt to various soil types.', 'Pine trees have a slow growth rate and require minimal maintenance. Pruning is generally not needed except for shaping young trees.', 'Pine Tree', 'Plant pine trees in the fall or spring in a location with full sun exposure. They are adaptable to different soil types and require little care once established.', 'Pine trees thrive in full sun and can grow in various soil types, from sandy to clayey soils.', 5, 5),
    (6, '2023-06-05', 'Clematis is a climbing vine with vibrant purple flowers. It has a fast growth rate and can quickly cover trellises and arbors. Clematis prefers partial to full sun and rich, well-drained soil.', 'Clematis is a fast-growing vine. Pruning in early spring helps promote healthy growth and abundant flowering.', 'Clematis', 'Plant clematis in the spring with partial to full sun exposure. Provide rich, well-drained soil and use a trellis for support. Prune in early spring.', 'Clematis vines thrive in well-drained soil and benefit from regular pruning and support for their climbing habit.', 6, 6),
    (7, '2023-07-12', 'Daffodils are bulbous plants with trumpet-shaped flowers. They have a moderate growth rate and are a spring garden favorite. Daffodils prefer full sun to partial shade and well-drained soil.', 'Daffodils have a moderate growth rate. Allow the foliage to wither naturally after blooming to store energy for the next year.', 'Daffodil', 'Plant daffodil bulbs in the fall for spring blooms. They require well-drained soil and can tolerate full sun to partial shade.', 'Daffodils thrive in well-drained soil and can add a pop of color to your garden. Their trumpet-shaped flowers are a delight.', 7, 7),
    (8, '2023-08-18', 'Red Rose is a classic rose variety known for its deep red petals. It has a moderate growth rate and is a symbol of love and beauty. Red Roses prefer full sun and well-drained soil.', 'Red Roses have a moderate growth rate. Pruning in late winter or early spring helps maintain their shape and promote new growth.', 'Red Rose', 'Plant Red Roses in the spring with full sun exposure and well-drained soil. Regular pruning in late winter or early spring keeps them healthy and blooming.', 'Red Roses thrive in well-drained soil with full sun exposure. Their deep red petals are a symbol of love and passion.', 8, 8),
    (9, '2023-09-22', 'Succulent Aloe is a drought-tolerant succulent known for its fleshy leaves. It has a slow growth rate and is a low-maintenance plant. Succulent Aloe prefers full sun and well-drained soil.', 'Succulent Aloe has a slow growth rate and requires minimal care. Allow the soil to dry between waterings to prevent overwatering.', 'Succulent Aloe', 'Plant Succulent Aloe in the spring in well-drained soil with full sun exposure. Water sparingly and let the soil dry between waterings.', 'Succulent Aloe thrives in well-drained soil and full sun. It is perfect for water-wise gardening.', 9, 9),
    (10, '2023-10-27', 'Tomato is a delicious and nutritious vegetable thats easy to grow. It has a fast growth rate and is a popular choice for home gardens. Tomatoes prefer full sun and regular watering.', 'Tomatoes have a fast growth rate. Pruning to remove excess foliage and staking can help support the plant as it grows.', 'Tomato', 'Plant tomatoes in the spring in well-drained soil with full sun exposure. Regular watering and staking are essential for a healthy crop.', 'Tomatoes need full sun, well-drained soil, and regular watering. They are versatile and can be used in various culinary dishes.', 10, 10) ON CONFLICT (id) DO NOTHING;

INSERT INTO post (id, content, date, image, title, author_id) VALUES
(8, 'Red Roses are not just flowers; they are symbols of love and beauty. In this comprehensive post, we will delve into the elegance of red roses, from their moderate growth to the importance of pruning for healthy growth. Discover why red roses have captured hearts for generations and the emotions they represent. This post is a tribute to the enduring beauty and symbolism of red roses in our lives.', '2023-08-20 00:00:00.000000', '/photos/post/8/img.png', 'The Elegance of Red Roses', 8),
(10, 'Tomatoes are not just a vegetable, they are a versatile culinary treasure. In this comprehensive post, we will guide you through the process of growing tomatoes in your backyard, from planting in the spring to providing regular care. Learn how to cultivate these delicious and nutritious fruits for your kitchen. This post is a culinary journey that celebrates the versatility of tomatoes in your culinary creations.', '2023-10-30 00:00:00.000000', '/photos/post/10/img.png', 'Tomatoes: A Versatile Vegetable', 10),
(3, 'Basil is not just a herb, it\s a culinary treasure. In this extensive post, we will uncover the world of basil, its rich history in the kitchen, and provide you with mouthwatering recipes that feature this aromatic herb. Learn the secrets to growing your own basil and infusing your dishes with its incredible flavor. Basil is a culinary delight, and this post will make you appreciate its versatility and taste.', '2023-03-25 00:00:00.000000', '/photos/post/3/fresh_basil.png', 'Basil: The Culinary Herb', 3),
(2, 'Scarlet Sage (Salvia coccinea) is a captivating annual flower that adds a splash of vibrant red to your garden. In this comprehensive post, we will guide you through the process of growing Scarlet Sage, from planting the seeds to caring for these beautiful blooms. Learn how to create a stunning display of red in your garden and witness the wonders of nature through the eyes of Scarlet Sage. Gardening has never been more exciting!', '2023-02-20 00:00:00.000000', '/photos/post/2/scarlet_sage.png', 'Scarlet Sage: A Splash of Red', 2),
(6, 'Clematis is a vibrant climbing vine known for its stunning purple flowers. In this comprehensive post, we will guide you through the world of Clematis, including its fast growth, pruning techniques, and the beauty it brings to trellises and arbors. Create a vertical garden with the help of Clematis and experience the joy of nurturing a climbing plant that enchants with its blooms.', '2023-06-10 00:00:00.000000', '/photos/post/6/img.png', 'Climbing with Clematis', 6),
(1, 'Lavender (Lavandula) is a versatile and enchanting plant known for its beautiful purple blooms and soothing fragrance. In this extensive post, we will delve deep into the world of lavender, exploring its various uses in gardening, aromatherapy, and culinary applications. Discover the many benefits of growing lavender in your garden and how to harness its aromatic wonders. Lavender is not just a plant, its a multifaceted gem that can transform your garden and enhance your well-being.', '2023-01-15 00:00:00.000000', '/photos/post/1/lavender.png', 'The Aromatic World of Lavender', 1),
(5, 'Pine trees are majestic guardians of the forest, with their evergreen foliage and towering presence. In this extensive post, we will explore the world of pine trees, from their slow growth and adaptability to the various soil types they thrive in. Learn why pine trees are not only beautiful but also vital to the ecosystem. Dive into the world of these towering giants and appreciate their role in the natural world.', '2023-05-05 00:00:00.000000', '/photos/post/5/img.png', 'Majestic Pine Trees', 5),
(7, 'Daffodils are heralds of spring with their cheerful trumpet-shaped flowers. In this comprehensive post, we will celebrate the beauty of daffodils, exploring their moderate growth rate and care requirements. Learn how to plant daffodil bulbs, and bring a burst of sunshine to your garden each spring with these stunning flowers. Embrace the magic of daffodils and transform your spring garden into a vibrant paradise.', '2023-07-15 00:00:00.000000', '/photos/post/7/img.png', 'Daffodils in Full Bloom', 7),
(9, 'Succulent Aloe is a low-maintenance beauty that thrives with minimal care. In this extensive post, we will explore the world of succulent aloe, from its slow growth and drought tolerance to its uses in skincare. Discover the resilience of succulent aloe and its adaptability to various environments. This post is a testament to the hardiness and versatility of succulent aloe, a plant that can thrive even in the most challenging conditions.', '2023-09-25 00:00:00.000000', '/photos/post/9/img.png', 'Succulent Aloe: Natures Survivor', 9),
(4, 'The Mock Orange (Philadelphus coronarius) shrub is renowned for its fragrant white blossoms that fill the garden with a delightful aroma. In this comprehensive post, we will take a closer look at this garden favorite, exploring its care requirements, pruning tips, and the joy it brings to your outdoor space. Discover the enchanting world of the Mock Orange and how it can transform your garden into a fragrant paradise.', '2023-04-30 00:00:00.000000', '/photos/post/4/mock_orange.png', 'Mock Orange: A Garden Delight', 4) ON CONFLICT (id) DO NOTHING;

INSERT INTO comment (id, content, "date", author_id, post_id)
VALUES
    (1, 'I love lavender! Its such a versatile and beautiful plant. Great post!', '2023-01-16', 1, 1),
    (2, 'Scarlet Sage is indeed a stunning flower. Your guide on growing it was very helpful!', '2023-02-21', 2, 2),
    (3, 'Basil is a must-have in my herb garden. Thanks for the delicious recipes!', '2023-03-26', 3, 3),
    (4, 'Mock Orange has been on my wishlist for a while. Your post convinced me to get one!', '2023-04-30', 4, 4),
    (5, 'Pine trees are true giants in the forest. Thanks for the informative post!', '2023-05-05', 5, 5),
    (6, 'Clematis is a favorite of mine for climbing structures. Great tips on care!', '2023-06-11', 6, 6),
    (7, 'Daffodils bring so much joy in the spring. Thanks for the planting tips!', '2023-07-16', 7, 7),
    (8, 'Red roses are the symbol of love, and your post beautifully captures their essence.', '2023-08-21', 8, 8),
    (9, 'Succulent aloe is a lifesaver in arid regions. Informative post!', '2023-09-26', 9, 9),
    (10, 'I cant wait to grow my own tomatoes this year. Thanks for the guidance!', '2023-10-31', 10, 10),
    (11, 'Lavender is not only beautiful but also has a calming effect. Love it!', '2023-01-17', 1, 1),
    (12, 'Scarlet Sage is my go-to for adding color to the garden. Your post is spot on!', '2023-02-22', 2, 2),
    (13, 'Basil is the king of herbs! Thanks for the wonderful recipes.', '2023-03-27', 3, 3),
    (14, 'Mock Orange has such a lovely scent. Im excited to have it in my garden.', '2023-04-30', 4, 4),
    (15, 'Pine trees are majestic. Your post makes me appreciate them even more.', '2023-05-06', 5, 5),
    (16, 'Clematis is a gem for trellises. Your care tips are valuable!', '2023-06-12', 6, 6),
    (17, 'Daffodils are a sign that spring has arrived. Thanks for the insights!', '2023-07-17', 7, 7),
    (18, 'Red roses are timeless. Your post beautifully captures their essence.', '2023-08-22', 8, 8),
    (19, 'Succulent aloe is a true survivor. Its a great addition to any garden.', '2023-09-27', 9, 9),
    (20, 'Tomatoes are a staple in my kitchen. Your post motivates me to grow my own!', '2023-11-01', 10, 10),
    (21, 'Lavenders scent is just amazing. Its a must-have in every garden.', '2023-01-18', 1, 1),
    (22, 'Scarlet Sages vibrant red is a sight to behold. Your gardening guide is top-notch!', '2023-02-23', 2, 2),
    (23, 'Basil elevates every dish. Thanks for the recipes and growing tips.', '2023-03-28', 3, 3),
    (24, 'Mock Oranges fragrance is heavenly. Im glad I learned about it from your post.', '2023-05-01', 4, 4),
    (25, 'Pine trees are the giants of the forest. Your post appreciates their importance.', '2023-05-07', 5, 5) ON CONFLICT (id) DO NOTHING;;

INSERT INTO message (id, content, "date", receiver_id, sender_id)
VALUES
    (1, 'I agree, lavender is a wonderful plant with a calming fragrance.', '2023-01-16', 1, 2),
    (2, 'Absolutely! The color and scent of lavender are unmatched.', '2023-02-21', 2, 1),
    (3, 'I just planted some Scarlet Sage in my garden, and its already blooming!', '2023-03-26', 1, 3),
    (4, 'Thats great to hear! Scarlet Sage brings a burst of color to any garden.', '2023-04-30', 3, 1),
    (5, 'Basil is my go-to herb for cooking. Do you have any favorite basil recipes?', '2023-05-05', 2, 3),
    (6, 'I love making fresh pesto with basil from my garden. Its the best!', '2023-06-11', 3, 2),
    (7, 'The Mock Orange in my yard is in full bloom, and the scent is incredible.', '2023-07-16', 1, 4),
    (8, 'I can imagine! Mock Orange blossoms are truly fragrant and lovely.', '2023-08-21', 4, 1),
    (9, 'Pine trees provide such a calming presence in the forest, dont you think?', '2023-09-26', 2, 4),
    (10, 'Absolutely! Their towering presence is awe-inspiring.', '2023-10-31', 4, 2),
    (11, 'Clematis vines are perfect for adding vertical interest to a garden.', '2023-01-17', 3, 5),
    (12, 'I agree. The vibrant purple blooms of Clematis are a sight to behold.', '2023-02-22', 5, 3),
    (13, 'Daffodils are a sure sign that spring has arrived. Do you have them in your garden?', '2023-03-27', 1, 5),
    (14, 'Yes, I have a bed of daffodils, and they never fail to bring cheer in spring.', '2023-04-30', 5, 1),
    (15, 'Red roses are timeless symbols of love and beauty.', '2023-05-06', 2, 6),
    (16, 'Indeed, red roses are classic and never go out of style.', '2023-06-12', 6, 2),
    (17, 'Succulent aloe is a great addition to any garden, especially in dry regions.', '2023-07-17', 1, 7),
    (18, 'Ive seen how resilient aloe is. Its perfect for arid environments.', '2023-08-22', 7, 1),
    (19, 'Im planning to grow my own tomatoes this year. Any tips for a beginner?', '2023-09-27', 2, 7),
    (20, 'Tomatoes thrive with plenty of sun and regular watering. Youll do great!', '2023-11-01', 7, 2),
    (21, 'Lavenders scent is so soothing. I keep it on my windowsill.', '2023-01-18', 1, 8),
    (22, 'A great idea! Lavender indoors can bring a sense of calm to any room.', '2023-02-23', 8, 1),
    (23, 'Scarlet Sage is a stunner in the garden. I cant get enough of its red flowers.', '2023-03-28', 2, 9),
    (24, 'I agree! The vivid red of Scarlet Sage is truly captivating.', '2023-05-01', 9, 2),
    (25, 'Basil is a kitchen essential. I use it in pasta, salads, and more!', '2023-05-07', 1, 10) ON CONFLICT (id) DO NOTHING;

-- Generate 200 calendar entries with random start and end dates (end date is after start date, max end date is 2023-12-31)
-- WITH RandomDates AS (
--     SELECT
--         id AS calendar_id,
--         ('2023-01-01'::DATE + floor(random() * 365) * '1 day'::INTERVAL) AS date_start,
--         (floor(random() * 50 + 10) * '1 day'::INTERVAL) AS date_range,
--         (floor(random() * 26) + 1) AS event_id,
--         (floor(random() * 10) + 1) AS plant_id
--     FROM generate_series(1, 200) AS id
-- )
-- INSERT INTO calendar (id, date_start, date_end, event_id, plant_id)
-- SELECT
--     calendar_id,
--     date_start,
--     LEAST(date_start + date_range, '2023-12-31'::DATE) AS date_end,
--     event_id,
--     plant_id
-- FROM RandomDates;

INSERT INTO calendar (id, date_end, date_start, event_id, plant_id) VALUES
(1, '2023-07-04', '2023-06-14', 6, 7),
(2, '2023-08-08', '2023-06-20', 4, 6),
(3, '2023-09-22', '2023-08-04', 26, 1),
(4, '2023-03-27', '2023-01-28', 15, 7),
(5, '2023-08-13', '2023-08-01', 25, 9),
(6, '2023-09-06', '2023-07-21', 8, 10),
(7, '2023-09-30', '2023-09-12', 22, 10),
(8, '2023-03-29', '2023-02-16', 3, 7),
(9, '2023-09-21', '2023-09-05', 17, 4),
(10, '2023-07-12', '2023-06-27', 16, 9),
(11, '2023-11-03', '2023-09-26', 23, 8),
(12, '2023-07-07', '2023-05-15', 17, 6),
(13, '2023-12-17', '2023-10-24', 1, 1),
(14, '2023-08-14', '2023-06-24', 14, 1),
(15, '2023-07-19', '2023-06-22', 24, 4),
(16, '2023-12-19', '2023-11-02', 17, 4),
(17, '2023-08-05', '2023-07-25', 13, 3),
(18, '2023-12-24', '2023-12-09', 4, 9),
(19, '2023-09-12', '2023-08-21', 1, 1),
(20, '2023-12-31', '2023-12-24', 3, 8),
(21, '2023-12-30', '2023-11-26', 23, 4),
(22, '2023-12-31', '2023-11-24', 6, 6),
(23, '2023-08-07', '2023-07-01', 18, 5),
(24, '2023-10-13', '2023-09-16', 3, 7),
(25, '2023-03-01', '2023-01-05', 22, 5),
(26, '2023-07-14', '2023-06-16', 24, 2),
(27, '2023-09-13', '2023-08-15', 8, 9),
(28, '2023-04-04', '2023-03-12', 19, 4),
(29, '2023-08-10', '2023-06-12', 2, 6),
(30, '2023-07-10', '2023-05-19', 8, 3),
(31, '2023-12-31', '2023-12-17', 19, 3),
(32, '2023-08-18', '2023-06-24', 6, 1),
(33, '2023-11-05', '2023-09-13', 20, 9),
(34, '2023-12-08', '2023-10-28', 5, 4),
(35, '2023-12-31', '2023-12-23', 20, 8),
(36, '2023-08-07', '2023-06-12', 16, 10),
(37, '2023-08-28', '2023-08-17', 13, 5),
(38, '2023-12-31', '2023-12-05', 13, 5),
(39, '2023-12-24', '2023-11-02', 23, 4),
(40, '2023-07-18', '2023-07-04', 4, 1),
(41, '2023-03-08', '2023-02-10', 22, 9),
(42, '2023-12-31', '2023-12-20', 23, 1),
(43, '2023-12-31', '2023-12-05', 9, 10),
(44, '2023-08-27', '2023-06-29', 23, 4),
(45, '2023-08-08', '2023-07-22', 20, 3),
(46, '2023-09-15', '2023-09-02', 23, 4),
(47, '2023-07-10', '2023-05-31', 8, 6),
(48, '2023-11-23', '2023-10-07', 12, 3),
(49, '2023-07-11', '2023-05-13', 15, 6),
(50, '2023-05-29', '2023-05-07', 16, 2),
(51, '2023-07-13', '2023-07-03', 17, 2),
(52, '2023-06-18', '2023-04-24', 8, 2),
(53, '2023-02-25', '2023-02-12', 17, 5),
(54, '2023-10-13', '2023-09-23', 15, 1),
(55, '2023-12-31', '2023-12-09', 23, 9),
(56, '2023-11-01', '2023-09-15', 6, 4),
(57, '2023-03-18', '2023-01-20', 18, 2),
(58, '2023-11-12', '2023-10-22', 5, 8),
(59, '2023-03-22', '2023-03-12', 8, 9),
(60, '2023-12-30', '2023-11-22', 15, 4),
(61, '2023-11-13', '2023-10-27', 5, 6),
(62, '2023-09-14', '2023-08-29', 17, 3),
(63, '2023-03-13', '2023-02-07', 1, 5),
(64, '2023-07-06', '2023-05-16', 26, 10),
(65, '2023-07-14', '2023-06-03', 26, 9),
(66, '2023-04-18', '2023-04-05', 6, 2),
(67, '2023-06-19', '2023-05-29', 3, 6),
(68, '2023-04-17', '2023-03-14', 1, 1),
(69, '2023-06-06', '2023-05-06', 1, 9),
(70, '2023-09-20', '2023-08-23', 10, 3),
(71, '2023-04-17', '2023-03-29', 4, 6),
(72, '2023-01-27', '2023-01-01', 13, 2),
(73, '2023-03-25', '2023-02-23', 5, 3),
(74, '2023-05-28', '2023-04-29', 7, 7),
(75, '2023-05-12', '2023-04-21', 8, 7),
(76, '2023-08-08', '2023-07-07', 17, 4),
(77, '2023-06-08', '2023-04-13', 19, 9),
(78, '2023-02-04', '2023-01-20', 6, 3),
(79, '2023-05-25', '2023-05-11', 23, 2),
(80, '2023-08-17', '2023-06-24', 26, 3),
(81, '2023-04-10', '2023-03-12', 18, 3),
(82, '2023-05-10', '2023-04-02', 19, 4),
(83, '2023-05-28', '2023-05-17', 12, 8),
(84, '2023-07-24', '2023-07-10', 10, 7),
(85, '2023-10-10', '2023-09-18', 14, 8),
(86, '2023-06-12', '2023-05-26', 20, 4),
(87, '2023-05-14', '2023-04-08', 25, 8),
(88, '2023-09-25', '2023-09-06', 12, 3),
(89, '2023-12-09', '2023-11-19', 17, 2),
(90, '2023-09-19', '2023-09-08', 1, 5),
(91, '2023-08-13', '2023-06-15', 15, 6),
(92, '2023-04-30', '2023-03-03', 19, 9),
(93, '2023-12-31', '2023-12-19', 21, 4),
(94, '2023-04-17', '2023-02-18', 25, 1),
(95, '2023-10-10', '2023-08-26', 4, 6),
(96, '2023-11-13', '2023-10-19', 13, 6),
(97, '2023-08-07', '2023-07-23', 20, 3),
(98, '2023-09-06', '2023-08-16', 21, 1),
(99, '2023-09-30', '2023-09-11', 17, 10),
(100, '2023-09-11', '2023-07-17', 19, 4),
(101, '2023-01-29', '2023-01-02', 20, 4),
(102, '2023-02-23', '2023-01-07', 16, 8),
(103, '2023-09-28', '2023-08-18', 25, 1),
(104, '2023-07-27', '2023-06-11', 2, 6),
(105, '2023-03-14', '2023-02-02', 5, 9),
(106, '2023-03-21', '2023-01-28', 24, 4),
(107, '2023-12-12', '2023-11-11', 18, 2),
(108, '2023-09-23', '2023-08-07', 9, 5),
(109, '2023-02-27', '2023-01-11', 5, 7),
(110, '2023-03-08', '2023-02-03', 25, 3),
(111, '2023-09-17', '2023-08-12', 11, 4),
(112, '2023-06-02', '2023-04-18', 20, 2),
(113, '2023-11-08', '2023-10-19', 11, 8),
(114, '2023-12-21', '2023-11-02', 7, 7),
(115, '2023-11-09', '2023-10-24', 4, 10),
(116, '2023-10-13', '2023-09-26', 18, 4),
(117, '2023-05-18', '2023-05-03', 24, 1),
(118, '2023-02-20', '2023-01-30', 3, 5),
(119, '2023-11-03', '2023-09-24', 8, 9),
(120, '2023-06-14', '2023-05-16', 15, 1),
(121, '2023-10-31', '2023-10-09', 9, 9),
(122, '2023-12-24', '2023-12-05', 18, 2),
(123, '2023-04-24', '2023-02-24', 15, 9),
(124, '2023-09-25', '2023-08-24', 3, 4),
(125, '2023-09-25', '2023-08-09', 2, 3),
(126, '2023-12-31', '2023-11-02', 14, 7),
(127, '2023-07-22', '2023-06-28', 2, 10),
(128, '2023-12-11', '2023-10-18', 25, 3),
(129, '2023-12-28', '2023-11-19', 5, 1),
(130, '2023-10-18', '2023-10-06', 19, 6),
(131, '2023-02-07', '2023-01-26', 13, 3),
(132, '2023-04-20', '2023-04-04', 20, 7),
(133, '2023-11-20', '2023-10-10', 11, 9),
(134, '2023-12-31', '2023-12-02', 14, 4),
(135, '2023-08-28', '2023-07-10', 21, 7),
(136, '2023-11-16', '2023-10-24', 23, 9),
(137, '2023-06-18', '2023-05-14', 23, 4),
(138, '2023-07-17', '2023-06-01', 22, 3),
(139, '2023-12-31', '2023-12-08', 15, 5),
(140, '2023-04-05', '2023-02-23', 25, 5),
(141, '2023-03-23', '2023-03-05', 8, 7),
(142, '2023-08-27', '2023-08-13', 2, 7),
(143, '2023-07-30', '2023-07-20', 22, 4),
(144, '2023-12-31', '2023-11-25', 11, 7),
(145, '2023-12-31', '2023-12-25', 5, 3),
(146, '2023-02-10', '2023-01-27', 10, 2),
(147, '2023-03-23', '2023-02-08', 20, 9),
(148, '2023-04-02', '2023-02-02', 13, 9),
(149, '2023-04-05', '2023-02-27', 15, 9),
(150, '2023-03-19', '2023-03-02', 8, 10),
(151, '2023-07-01', '2023-05-14', 9, 2),
(152, '2023-03-11', '2023-02-15', 11, 7),
(153, '2023-10-12', '2023-09-02', 16, 10),
(154, '2023-03-06', '2023-02-08', 12, 8),
(155, '2023-06-17', '2023-05-30', 19, 2),
(156, '2023-08-19', '2023-07-06', 13, 7),
(157, '2023-08-13', '2023-07-24', 3, 1),
(158, '2023-07-29', '2023-07-15', 18, 10),
(159, '2023-08-29', '2023-07-06', 13, 9),
(160, '2023-02-11', '2023-01-16', 24, 7),
(161, '2023-08-22', '2023-07-13', 6, 2),
(162, '2023-08-28', '2023-07-13', 25, 10),
(163, '2023-03-02', '2023-01-26', 10, 3),
(164, '2023-08-20', '2023-07-08', 18, 6),
(165, '2023-10-20', '2023-09-12', 13, 5),
(166, '2023-08-07', '2023-07-18', 26, 8),
(167, '2023-12-16', '2023-12-04', 11, 10),
(168, '2023-11-08', '2023-10-03', 24, 10),
(169, '2023-08-15', '2023-07-31', 1, 9),
(170, '2023-03-31', '2023-03-17', 4, 2),
(171, '2023-04-04', '2023-03-20', 1, 1),
(172, '2023-12-31', '2023-12-22', 2, 10),
(173, '2023-08-22', '2023-06-28', 17, 1),
(174, '2023-01-28', '2023-01-09', 6, 9),
(175, '2023-08-12', '2023-07-29', 21, 1),
(176, '2023-09-28', '2023-08-23', 21, 4),
(177, '2023-02-07', '2023-01-17', 1, 7),
(178, '2023-04-11', '2023-03-30', 26, 2),
(179, '2023-07-01', '2023-06-04', 16, 7),
(180, '2023-10-04', '2023-08-18', 13, 7),
(181, '2023-07-23', '2023-05-29', 12, 4),
(182, '2023-07-27', '2023-06-12', 8, 3),
(183, '2023-12-30', '2023-12-07', 8, 4),
(184, '2023-05-11', '2023-04-03', 2, 8),
(185, '2023-11-30', '2023-10-02', 2, 7),
(186, '2023-05-24', '2023-03-30', 10, 6),
(187, '2023-07-28', '2023-06-17', 13, 1),
(188, '2023-04-07', '2023-03-12', 16, 4),
(189, '2023-09-23', '2023-08-26', 2, 6),
(190, '2023-10-22', '2023-08-30', 26, 10),
(191, '2023-05-22', '2023-04-25', 7, 1),
(192, '2023-12-31', '2023-11-23', 23, 3),
(193, '2023-02-22', '2023-01-08', 24, 1),
(194, '2023-06-20', '2023-05-03', 6, 8),
(195, '2023-01-21', '2023-01-04', 11, 10),
(196, '2023-10-15', '2023-08-30', 14, 4),
(197, '2023-04-24', '2023-04-01', 6, 9),
(200, '2023-06-04', '2023-05-03', 20, 9),
(198, '2023-12-31', '2023-12-16', 17, 4),
(199, '2023-04-24', '2023-03-18', 21, 6) ON CONFLICT (id) DO NOTHING;

INSERT INTO observed (user_id, plant_id)
VALUES
    (1, 3),
    (2, 5),
    (3, 7),
    (4, 2),
    (5, 9),
    (6, 1),
    (7, 4),
    (8, 6),
    (9, 8),
    (10, 10),
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 6),
    (6, 7),
    (7, 8),
    (8, 9),
    (9, 10),
    (10, 1),
    (1, 8),
    (2, 7),
    (3, 6),
    (4, 9),
    (5, 4),
    (6, 5),
    (7, 10),
    (8, 2),
    (9, 3),
    (10, 4),
    (1, 5),
    (2, 6),
    (3, 2),
    (4, 7),
    (5, 3),
    (6, 10),
    (7, 1),
    (8, 10),
    (9, 1),
    (10, 5) ON CONFLICT (user_id, plant_id) DO NOTHING;

-- Generate 120 SQL INSERT statements
INSERT INTO plant_sub_category (plant_id, sub_category_id)
VALUES (1, 2),
       (7, 12),
       (3, 5),
       (9, 20),
       (4, 38),
       (6, 31),
       (2, 14),
       (8, 11),
       (10, 25),
       (1, 29),
       (5, 7),
       (7, 16),
       (3, 22),
       (9, 37),
       (4, 1),
       (6, 22),
       (2, 9),
       (8, 18),
       (10, 4),
       (1, 30),
       (5, 35),
       (7, 26),
       (3, 8),
       (9, 15),
       (4, 21),
       (6, 2),
       (2, 39),
       (8, 19),
       (10, 28),
       (1, 13),
       (5, 36),
       (7, 10),
       (3, 32),
       (9, 17),
       (4, 23),
       (6, 3),
       (2, 27),
       (8, 12),
       (10, 6),
       (1, 34),
       (5, 27),
       (7, 14),
       (3, 12),
       (9, 5),
       (4, 25),
       (6, 33),
       (2, 8),
       (8, 7),
       (10, 30),
       (1, 16),
       (5, 18),
       (7, 22),
       (3, 39),
       (9, 31),
       (4, 3),
       (6, 1),
       (2, 37),
       (8, 20),
       (10, 29),
       (1, 4),
       (5, 9),
       (7, 35),
       (3, 6),
       (9, 13),
       (4, 26),
       (6, 12),
       (2, 31),
       (8, 24),
       (10, 32),
       (1, 19),
       (5, 38),
       (7, 21),
       (3, 11),
       (9, 14),
       (4, 7),
       (6, 27),
       (2, 34),
       (8, 10),
       (10, 23),
       (1, 37),
       (5, 1),
       (7, 33),
       (3, 2),
       (9, 8),
       (4, 16),
       (6, 36),
       (2, 38),
       (8, 26),
       (10, 12),
       (1, 21),
       (5, 3),
       (7, 25),
       (3, 30),
       (9, 29),
       (4, 9),
       (6, 13),
       (2, 5),
       (8, 5),
       (10, 31),
       (1, 36),
       (5, 20),
       (7, 24),
       (3, 15),
       (9, 22),
       (4, 34),
       (6, 11),
       (2, 28),
       (8, 2),
       (10, 39),
       (1, 28),
       (5, 26),
       (7, 32),
       (3, 4),
       (9, 7),
       (4, 18),
       (6, 38),
       (2, 13),
       (8, 6),
       (10, 22),
       (1, 14),
       (5, 33),
       (7, 11),
       (3, 35),
       (9, 18),
       (4, 31),
       (6, 5),
       (2, 15),
       (8, 28),
       (10, 20) ON CONFLICT (sub_category_id,plant_id) DO NOTHING;


INSERT INTO image (id, file_path, plant_id)
VALUES
    (2, '/photos/plant/1/lavender.png', 1),
    (1, '/photos/plant/1/img.png', 1),
    (3, '/photos/plant/2/img.png', 2),
    (4, '/photos/plant/2/img_1.png', 2),
    (5, '/photos/plant/2/scarlet_sage.png', 2),
    (6, '/photos/plant/3/img.png', 3),
    (7, '/photos/plant/3/fresh_basil.png', 3),
    (8, '/photos/plant/4/img.png', 4),
    (9, '/photos/plant/4/mock_orange.png', 4),
    (10, '/photos/plant/5/img.png', 5),
    (11, '/photos/plant/5/img_1.png', 5),
    (12, '/photos/plant/6/img.png', 6),
    (13, '/photos/plant/6/img_1.png', 6),
    (14, '/photos/plant/7/img.png', 7),
    (15, '/photos/plant/7/img_1.png', 7),
    (16, '/photos/plant/8/img.png', 8),
    (17, '/photos/plant/8/img_1.png', 8),
    (18, '/photos/plant/9/img.png', 9),
    (19, '/photos/plant/9/img_1.png', 9),
    (20, '/photos/plant/10/img.png', 10),
    (21, '/photos/plant/10/img_1.png', 10) ON CONFLICT (id) DO NOTHING;
