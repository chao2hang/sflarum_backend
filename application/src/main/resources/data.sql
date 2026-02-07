CREATE TABLE `f_access_tokens` (
                                   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                   `token` varchar(40) NOT NULL,
                                   `user_id` int(10) unsigned NOT NULL,
                                   `last_activity_at` datetime DEFAULT NULL,
                                   `created_at` datetime NOT NULL,
                                   `type` varchar(100) NOT NULL,
                                   `title` varchar(150) DEFAULT NULL,
                                   `last_ip_address` varchar(45) DEFAULT NULL,
                                   `last_user_agent` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `f_access_tokens_token_unique` (`token`),
                                   KEY `f_access_tokens_user_id_foreign` (`user_id`),
                                   KEY `f_access_tokens_type_index` (`type`),
                                   CONSTRAINT `f_access_tokens_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_api_keys` (
                              `key` varchar(100) NOT NULL,
                              `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                              `allowed_ips` varchar(255) DEFAULT NULL,
                              `scopes` varchar(255) DEFAULT NULL,
                              `user_id` int(10) unsigned DEFAULT NULL,
                              `created_at` datetime NOT NULL,
                              `last_activity_at` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `f_api_keys_key_unique` (`key`),
                              KEY `f_api_keys_user_id_foreign` (`user_id`),
                              CONSTRAINT `f_api_keys_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_badge_category` (
                                    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                    `name` varchar(46) NOT NULL,
                                    `order` int(11) NOT NULL DEFAULT 0,
                                    `description` text DEFAULT NULL,
                                    `is_enabled` tinyint(1) NOT NULL DEFAULT 1,
                                    `created_at` datetime NOT NULL,
                                    `is_table` tinyint(1) NOT NULL DEFAULT 1,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_badge_user` (
                                `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                `user_id` int(10) unsigned NOT NULL,
                                `badge_id` int(10) unsigned NOT NULL,
                                `description` text DEFAULT NULL,
                                `is_primary` tinyint(1) NOT NULL DEFAULT 0,
                                `assigned_at` datetime NOT NULL,
                                `in_user_card` tinyint(1) NOT NULL DEFAULT 0,
                                PRIMARY KEY (`id`),
                                KEY `f_badge_user_user_id_foreign` (`user_id`),
                                KEY `f_badge_user_badge_id_foreign` (`badge_id`),
                                CONSTRAINT `f_badge_user_badge_id_foreign` FOREIGN KEY (`badge_id`) REFERENCES `f_badges` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_badge_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_badges` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(46) NOT NULL,
                            `icon` varchar(100) DEFAULT NULL,
                            `order` int(11) NOT NULL DEFAULT 0,
                            `image` text DEFAULT NULL,
                            `description` text DEFAULT NULL,
                            `is_visible` tinyint(1) NOT NULL DEFAULT 1,
                            `created_at` datetime NOT NULL,
                            `badge_category_id` int(10) unsigned DEFAULT NULL,
                            `points` int(11) NOT NULL DEFAULT 0,
                            `background_color` varchar(50) DEFAULT NULL,
                            `icon_color` varchar(50) DEFAULT NULL,
                            `label_color` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `f_badges_badge_category_id_foreign` (`badge_category_id`),
                            CONSTRAINT `f_badges_badge_category_id_foreign` FOREIGN KEY (`badge_category_id`) REFERENCES `f_badge_category` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_criteria` (
                              `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                              `last_edited_by_id` int(10) unsigned NOT NULL,
                              `name` varchar(200) NOT NULL,
                              `icon` varchar(50) NOT NULL,
                              `description` text NOT NULL,
                              `metrics` text NOT NULL,
                              `requirements` text NOT NULL,
                              `actions` text NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `f_criteria_last_edited_by_id_foreign` (`last_edited_by_id`),
                              CONSTRAINT `f_criteria_last_edited_by_id_foreign` FOREIGN KEY (`last_edited_by_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_criterion_user` (
                                    `criterion_id` int(10) unsigned NOT NULL,
                                    `user_id` int(10) unsigned NOT NULL,
                                    PRIMARY KEY (`criterion_id`,`user_id`),
                                    KEY `f_criterion_user_user_id_foreign` (`user_id`),
                                    CONSTRAINT `f_criterion_user_criterion_id_foreign` FOREIGN KEY (`criterion_id`) REFERENCES `f_criteria` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `f_criterion_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_discussion_sticky_tag` (
                                           `discussion_id` int(10) unsigned NOT NULL,
                                           `tag_id` int(10) unsigned NOT NULL,
                                           PRIMARY KEY (`discussion_id`,`tag_id`),
                                           KEY `f_discussion_sticky_tag_tag_id_foreign` (`tag_id`),
                                           CONSTRAINT `f_discussion_sticky_tag_discussion_id_foreign` FOREIGN KEY (`discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                           CONSTRAINT `f_discussion_sticky_tag_tag_id_foreign` FOREIGN KEY (`tag_id`) REFERENCES `f_tags` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_discussion_tag` (
                                    `discussion_id` int(10) unsigned NOT NULL,
                                    `tag_id` int(10) unsigned NOT NULL,
                                    `created_at` timestamp NULL DEFAULT current_timestamp(),
                                    PRIMARY KEY (`discussion_id`,`tag_id`),
                                    KEY `f_discussion_tag_tag_id_foreign` (`tag_id`),
                                    CONSTRAINT `f_discussion_tag_discussion_id_foreign` FOREIGN KEY (`discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `f_discussion_tag_tag_id_foreign` FOREIGN KEY (`tag_id`) REFERENCES `f_tags` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_discussion_user` (
                                     `user_id` int(10) unsigned NOT NULL,
                                     `discussion_id` int(10) unsigned NOT NULL,
                                     `last_read_at` datetime DEFAULT NULL,
                                     `last_read_post_number` int(10) unsigned DEFAULT NULL,
                                     `subscription` enum('follow','ignore') DEFAULT NULL,
                                     PRIMARY KEY (`user_id`,`discussion_id`),
                                     KEY `f_discussion_user_discussion_id_foreign` (`discussion_id`),
                                     CONSTRAINT `f_discussion_user_discussion_id_foreign` FOREIGN KEY (`discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE CASCADE,
                                     CONSTRAINT `f_discussion_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_discussion_views` (
                                      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                      `user_id` int(10) unsigned DEFAULT NULL,
                                      `discussion_id` int(10) unsigned NOT NULL,
                                      `ip` varchar(16) NOT NULL,
                                      `visited_at` datetime NOT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `f_discussion_views_discussion_id_foreign` (`discussion_id`),
                                      KEY `f_discussion_views_user_id_foreign` (`user_id`),
                                      CONSTRAINT `f_discussion_views_discussion_id_foreign` FOREIGN KEY (`discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                      CONSTRAINT `f_discussion_views_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_discussions` (
                                 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                 `title` varchar(200) NOT NULL,
                                 `comment_count` int(11) NOT NULL DEFAULT 1,
                                 `participant_count` int(10) unsigned NOT NULL DEFAULT 0,
                                 `post_number_index` int(10) unsigned NOT NULL DEFAULT 0,
                                 `created_at` datetime NOT NULL,
                                 `user_id` int(10) unsigned DEFAULT NULL,
                                 `first_post_id` int(10) unsigned DEFAULT NULL,
                                 `last_posted_at` datetime DEFAULT NULL,
                                 `last_posted_user_id` int(10) unsigned DEFAULT NULL,
                                 `last_post_id` int(10) unsigned DEFAULT NULL,
                                 `last_post_number` int(10) unsigned DEFAULT NULL,
                                 `hidden_at` datetime DEFAULT NULL,
                                 `hidden_user_id` int(10) unsigned DEFAULT NULL,
                                 `slug` varchar(255) NOT NULL,
                                 `is_private` tinyint(1) NOT NULL DEFAULT 0,
                                 `is_approved` tinyint(1) NOT NULL DEFAULT 1,
                                 `is_sticky` tinyint(1) NOT NULL DEFAULT 0,
                                 `is_locked` tinyint(1) NOT NULL DEFAULT 0,
                                 `view_count` int(11) NOT NULL DEFAULT 0,
                                 `best_answer_post_id` int(10) unsigned DEFAULT NULL,
                                 `best_answer_user_id` int(10) unsigned DEFAULT NULL,
                                 `best_answer_notified` tinyint(1) NOT NULL,
                                 `best_answer_set_at` datetime DEFAULT NULL,
                                 `votes` int(11) NOT NULL,
                                 `hotness` double(10,4) NOT NULL,
                                 `is_stickiest` tinyint(1) NOT NULL DEFAULT 0,
                                 `is_tag_sticky` tinyint(1) NOT NULL DEFAULT 0,
                                 PRIMARY KEY (`id`),
                                 KEY `f_discussions_hidden_user_id_foreign` (`hidden_user_id`),
                                 KEY `f_discussions_first_post_id_foreign` (`first_post_id`),
                                 KEY `f_discussions_last_post_id_foreign` (`last_post_id`),
                                 KEY `f_discussions_last_posted_at_index` (`last_posted_at`),
                                 KEY `f_discussions_last_posted_user_id_index` (`last_posted_user_id`),
                                 KEY `f_discussions_created_at_index` (`created_at`),
                                 KEY `f_discussions_user_id_index` (`user_id`),
                                 KEY `f_discussions_comment_count_index` (`comment_count`),
                                 KEY `f_discussions_participant_count_index` (`participant_count`),
                                 KEY `f_discussions_hidden_at_index` (`hidden_at`),
                                 KEY `f_discussions_is_sticky_created_at_index` (`is_sticky`,`created_at`),
                                 KEY `f_discussions_is_sticky_last_posted_at_index` (`is_sticky`,`last_posted_at`),
                                 KEY `f_discussions_is_locked_index` (`is_locked`),
                                 KEY `f_discussions_best_answer_post_id_foreign` (`best_answer_post_id`),
                                 KEY `f_discussions_best_answer_user_id_foreign` (`best_answer_user_id`),
                                 KEY `f_discussions_best_answer_set_at_index` (`best_answer_set_at`),
                                 KEY `f_discussions_votes_index` (`votes`),
                                 KEY `f_discussions_is_stickiest_last_posted_at_index` (`is_stickiest`,`last_posted_at`),
                                 KEY `f_discussions_is_stickiest_created_at_index` (`is_stickiest`,`created_at`),
                                 KEY `f_discussions_is_tag_sticky_last_posted_at_index` (`is_tag_sticky`,`last_posted_at`),
                                 KEY `f_discussions_is_tag_sticky_created_at_index` (`is_tag_sticky`,`created_at`),
                                 FULLTEXT KEY `title` (`title`),
                                 CONSTRAINT `f_discussions_best_answer_post_id_foreign` FOREIGN KEY (`best_answer_post_id`) REFERENCES `f_posts` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_best_answer_user_id_foreign` FOREIGN KEY (`best_answer_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_first_post_id_foreign` FOREIGN KEY (`first_post_id`) REFERENCES `f_posts` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_hidden_user_id_foreign` FOREIGN KEY (`hidden_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_last_post_id_foreign` FOREIGN KEY (`last_post_id`) REFERENCES `f_posts` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_last_posted_user_id_foreign` FOREIGN KEY (`last_posted_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                                 CONSTRAINT `f_discussions_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=386 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_drafts` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `user_id` int(10) unsigned NOT NULL,
                            `title` varchar(255) DEFAULT NULL,
                            `content` mediumtext DEFAULT NULL,
                            `relationships` varchar(255) NOT NULL,
                            `updated_at` datetime NOT NULL,
                            `scheduled_for` datetime DEFAULT NULL,
                            `scheduled_validation_error` mediumtext DEFAULT NULL,
                            `ip_address` varchar(45) DEFAULT NULL,
                            `extra` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `f_drafts_user_id_foreign` (`user_id`),
                            CONSTRAINT `f_drafts_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_email_tokens` (
                                  `token` varchar(100) NOT NULL,
                                  `email` varchar(254) NOT NULL,
                                  `user_id` int(10) unsigned NOT NULL,
                                  `created_at` datetime DEFAULT NULL,
                                  PRIMARY KEY (`token`),
                                  KEY `f_email_tokens_user_id_foreign` (`user_id`),
                                  CONSTRAINT `f_email_tokens_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_flags` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `post_id` int(10) unsigned NOT NULL,
                           `type` varchar(255) NOT NULL,
                           `user_id` int(10) unsigned DEFAULT NULL,
                           `reason` varchar(255) DEFAULT NULL,
                           `reason_detail` text DEFAULT NULL,
                           `created_at` datetime NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `f_flags_post_id_foreign` (`post_id`),
                           KEY `f_flags_user_id_foreign` (`user_id`),
                           KEY `f_flags_created_at_index` (`created_at`),
                           CONSTRAINT `f_flags_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                           CONSTRAINT `f_flags_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_group_permission` (
                                      `group_id` int(10) unsigned NOT NULL,
                                      `permission` varchar(100) NOT NULL,
                                      `created_at` timestamp NULL DEFAULT current_timestamp(),
                                      PRIMARY KEY (`group_id`,`permission`),
                                      CONSTRAINT `f_group_permission_group_id_foreign` FOREIGN KEY (`group_id`) REFERENCES `f_groups` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_group_user` (
                                `user_id` int(10) unsigned NOT NULL,
                                `group_id` int(10) unsigned NOT NULL,
                                `created_at` timestamp NULL DEFAULT current_timestamp(),
                                PRIMARY KEY (`user_id`,`group_id`),
                                KEY `f_group_user_group_id_foreign` (`group_id`),
                                CONSTRAINT `f_group_user_group_id_foreign` FOREIGN KEY (`group_id`) REFERENCES `f_groups` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_group_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_groups` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `name_singular` varchar(100) NOT NULL,
                            `name_plural` varchar(100) NOT NULL,
                            `color` varchar(20) DEFAULT NULL,
                            `icon` varchar(100) DEFAULT NULL,
                            `is_hidden` tinyint(1) NOT NULL DEFAULT 0,
                            `created_at` timestamp NULL DEFAULT current_timestamp(),
                            `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_jetbrains_keys` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) NOT NULL,
                                    `keyword` varchar(50) NOT NULL,
                                    `software_key` text NOT NULL,
                                    `created_at` timestamp NULL DEFAULT current_timestamp(),
                                    `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE KEY `keyword` (`keyword`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC

CREATE TABLE `f_login_providers` (
                                     `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                     `user_id` int(10) unsigned NOT NULL,
                                     `provider` varchar(100) NOT NULL,
                                     `identifier` varchar(100) NOT NULL,
                                     `created_at` datetime DEFAULT NULL,
                                     `last_login_at` datetime DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `f_login_providers_provider_identifier_unique` (`provider`,`identifier`),
                                     KEY `f_login_providers_user_id_foreign` (`user_id`),
                                     CONSTRAINT `f_login_providers_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_migrations` (
                                `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                `migration` varchar(255) NOT NULL,
                                `extension` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_notifications` (
                                   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                   `user_id` int(10) unsigned NOT NULL,
                                   `from_user_id` int(10) unsigned DEFAULT NULL,
                                   `type` varchar(100) NOT NULL,
                                   `subject_id` int(10) unsigned DEFAULT NULL,
                                   `data` blob DEFAULT NULL,
                                   `created_at` datetime NOT NULL,
                                   `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
                                   `read_at` datetime DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `f_notifications_from_user_id_foreign` (`from_user_id`),
                                   KEY `f_notifications_user_id_index` (`user_id`),
                                   CONSTRAINT `f_notifications_from_user_id_foreign` FOREIGN KEY (`from_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                                   CONSTRAINT `f_notifications_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_password_tokens` (
                                     `token` varchar(100) NOT NULL,
                                     `user_id` int(10) unsigned NOT NULL,
                                     `created_at` datetime DEFAULT NULL,
                                     PRIMARY KEY (`token`),
                                     KEY `f_password_tokens_user_id_foreign` (`user_id`),
                                     CONSTRAINT `f_password_tokens_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_poll_options` (
                                  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                  `answer` varchar(255) NOT NULL,
                                  `poll_id` int(10) unsigned NOT NULL,
                                  `created_at` timestamp NULL DEFAULT NULL,
                                  `updated_at` timestamp NULL DEFAULT NULL,
                                  `vote_count` int(10) unsigned NOT NULL DEFAULT 0,
                                  `image_url` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `f_poll_options_poll_id_foreign` (`poll_id`),
                                  CONSTRAINT `f_poll_options_poll_id_foreign` FOREIGN KEY (`poll_id`) REFERENCES `f_polls` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_poll_votes` (
                                `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                `poll_id` int(10) unsigned NOT NULL,
                                `option_id` int(10) unsigned NOT NULL,
                                `user_id` int(10) unsigned DEFAULT NULL,
                                `created_at` timestamp NULL DEFAULT NULL,
                                `updated_at` timestamp NULL DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `f_poll_votes_poll_id_foreign` (`poll_id`),
                                KEY `f_poll_votes_option_id_foreign` (`option_id`),
                                KEY `f_poll_votes_user_id_foreign` (`user_id`),
                                CONSTRAINT `f_poll_votes_option_id_foreign` FOREIGN KEY (`option_id`) REFERENCES `f_poll_options` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_poll_votes_poll_id_foreign` FOREIGN KEY (`poll_id`) REFERENCES `f_polls` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_poll_votes_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_polls` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `question` varchar(255) NOT NULL,
                           `subtitle` text DEFAULT NULL,
                           `image` text DEFAULT NULL,
                           `image_alt` varchar(255) DEFAULT NULL,
                           `post_id` int(10) unsigned DEFAULT NULL,
                           `user_id` int(10) unsigned DEFAULT NULL,
                           `public_poll` tinyint(1) NOT NULL,
                           `end_date` timestamp NULL DEFAULT NULL,
                           `created_at` timestamp NULL DEFAULT NULL,
                           `updated_at` timestamp NULL DEFAULT NULL,
                           `vote_count` int(10) unsigned NOT NULL DEFAULT 0,
                           `allow_multiple_votes` tinyint(1) NOT NULL DEFAULT 0,
                           `max_votes` int(10) unsigned NOT NULL DEFAULT 0,
                           `settings` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`settings`)),
                           PRIMARY KEY (`id`),
                           KEY `f_polls_user_id_foreign` (`user_id`),
                           KEY `f_polls_post_id_foreign` (`post_id`),
                           CONSTRAINT `f_polls_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                           CONSTRAINT `f_polls_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_likes` (
                                `post_id` int(10) unsigned NOT NULL,
                                `user_id` int(10) unsigned NOT NULL,
                                `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
                                PRIMARY KEY (`post_id`,`user_id`),
                                KEY `f_post_likes_user_id_foreign` (`user_id`),
                                CONSTRAINT `f_post_likes_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_post_likes_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_mentions_group` (
                                         `post_id` int(10) unsigned NOT NULL,
                                         `mentions_group_id` int(10) unsigned NOT NULL,
                                         `created_at` datetime DEFAULT current_timestamp(),
                                         PRIMARY KEY (`post_id`,`mentions_group_id`),
                                         KEY `f_post_mentions_group_mentions_group_id_foreign` (`mentions_group_id`),
                                         CONSTRAINT `f_post_mentions_group_mentions_group_id_foreign` FOREIGN KEY (`mentions_group_id`) REFERENCES `f_groups` (`id`) ON DELETE CASCADE,
                                         CONSTRAINT `f_post_mentions_group_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_mentions_post` (
                                        `post_id` int(10) unsigned NOT NULL,
                                        `mentions_post_id` int(10) unsigned NOT NULL,
                                        `created_at` timestamp NULL DEFAULT current_timestamp(),
                                        PRIMARY KEY (`post_id`,`mentions_post_id`),
                                        KEY `f_post_mentions_post_mentions_post_id_foreign` (`mentions_post_id`),
                                        CONSTRAINT `f_post_mentions_post_mentions_post_id_foreign` FOREIGN KEY (`mentions_post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                                        CONSTRAINT `f_post_mentions_post_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_mentions_tag` (
                                       `post_id` int(10) unsigned NOT NULL,
                                       `mentions_tag_id` int(10) unsigned NOT NULL,
                                       `created_at` datetime DEFAULT current_timestamp(),
                                       PRIMARY KEY (`post_id`,`mentions_tag_id`),
                                       KEY `f_post_mentions_tag_mentions_tag_id_foreign` (`mentions_tag_id`),
                                       CONSTRAINT `f_post_mentions_tag_mentions_tag_id_foreign` FOREIGN KEY (`mentions_tag_id`) REFERENCES `f_tags` (`id`) ON DELETE CASCADE,
                                       CONSTRAINT `f_post_mentions_tag_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_mentions_user` (
                                        `post_id` int(10) unsigned NOT NULL,
                                        `mentions_user_id` int(10) unsigned NOT NULL,
                                        `created_at` timestamp NULL DEFAULT current_timestamp(),
                                        PRIMARY KEY (`post_id`,`mentions_user_id`),
                                        KEY `f_post_mentions_user_mentions_user_id_foreign` (`mentions_user_id`),
                                        CONSTRAINT `f_post_mentions_user_mentions_user_id_foreign` FOREIGN KEY (`mentions_user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE,
                                        CONSTRAINT `f_post_mentions_user_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_user` (
                               `post_id` int(10) unsigned NOT NULL,
                               `user_id` int(10) unsigned NOT NULL,
                               PRIMARY KEY (`post_id`,`user_id`),
                               KEY `f_post_user_user_id_foreign` (`user_id`),
                               CONSTRAINT `f_post_user_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                               CONSTRAINT `f_post_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_post_votes` (
                                `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                                `post_id` int(10) unsigned NOT NULL,
                                `user_id` int(10) unsigned NOT NULL,
                                `value` int(11) NOT NULL DEFAULT 0,
                                `created_at` timestamp NULL DEFAULT NULL,
                                `updated_at` timestamp NULL DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `f_post_votes_post_id_user_id_unique` (`post_id`,`user_id`),
                                KEY `f_post_votes_user_id_foreign` (`user_id`),
                                CONSTRAINT `f_post_votes_post_id_foreign` FOREIGN KEY (`post_id`) REFERENCES `f_posts` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `f_post_votes_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_posts` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `discussion_id` int(10) unsigned NOT NULL,
                           `number` int(10) unsigned DEFAULT NULL,
                           `created_at` datetime NOT NULL,
                           `user_id` int(10) unsigned DEFAULT NULL,
                           `type` varchar(100) DEFAULT NULL,
                           `content` mediumtext DEFAULT NULL COMMENT ' ',
                           `edited_at` datetime DEFAULT NULL,
                           `edited_user_id` int(10) unsigned DEFAULT NULL,
                           `hidden_at` datetime DEFAULT NULL,
                           `hidden_user_id` int(10) unsigned DEFAULT NULL,
                           `ip_address` varchar(45) DEFAULT NULL,
                           `is_private` tinyint(1) NOT NULL DEFAULT 0,
                           `is_approved` tinyint(1) NOT NULL DEFAULT 1,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `f_posts_discussion_id_number_unique` (`discussion_id`,`number`),
                           KEY `f_posts_edited_user_id_foreign` (`edited_user_id`),
                           KEY `f_posts_hidden_user_id_foreign` (`hidden_user_id`),
                           KEY `f_posts_discussion_id_number_index` (`discussion_id`,`number`),
                           KEY `f_posts_discussion_id_created_at_index` (`discussion_id`,`created_at`),
                           KEY `f_posts_user_id_created_at_index` (`user_id`,`created_at`),
                           KEY `f_posts_type_index` (`type`),
                           KEY `f_posts_type_created_at_index` (`type`,`created_at`),
                           FULLTEXT KEY `content` (`content`),
                           CONSTRAINT `f_posts_discussion_id_foreign` FOREIGN KEY (`discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE CASCADE,
                           CONSTRAINT `f_posts_edited_user_id_foreign` FOREIGN KEY (`edited_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                           CONSTRAINT `f_posts_hidden_user_id_foreign` FOREIGN KEY (`hidden_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                           CONSTRAINT `f_posts_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=609 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_rank_users` (
                                `rank_id` int(10) unsigned NOT NULL,
                                `user_id` int(10) unsigned NOT NULL,
                                PRIMARY KEY (`user_id`,`rank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_ranks` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `points` int(10) unsigned NOT NULL,
                           `name` varchar(255) NOT NULL,
                           `color` varchar(255) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_registration_tokens` (
                                         `token` varchar(100) NOT NULL,
                                         `payload` text DEFAULT NULL,
                                         `created_at` datetime DEFAULT NULL,
                                         `provider` varchar(255) NOT NULL,
                                         `identifier` varchar(255) NOT NULL,
                                         `user_attributes` text DEFAULT NULL,
                                         PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_settings` (
                              `key` varchar(100) NOT NULL,
                              `value` text DEFAULT NULL,
                              PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_tag_user` (
                              `user_id` int(10) unsigned NOT NULL,
                              `tag_id` int(10) unsigned NOT NULL,
                              `marked_as_read_at` datetime DEFAULT NULL,
                              `is_hidden` tinyint(1) NOT NULL DEFAULT 0,
                              `subscription` enum('follow','lurk','ignore','hide') DEFAULT NULL,
                              `created_at` timestamp NULL DEFAULT current_timestamp(),
                              `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                              PRIMARY KEY (`user_id`,`tag_id`),
                              KEY `f_tag_user_tag_id_foreign` (`tag_id`),
                              KEY `f_tag_user_user_id_subscription_index` (`user_id`,`subscription`),
                              KEY `f_tag_user_subscription_index` (`subscription`),
                              CONSTRAINT `f_tag_user_tag_id_foreign` FOREIGN KEY (`tag_id`) REFERENCES `f_tags` (`id`) ON DELETE CASCADE,
                              CONSTRAINT `f_tag_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `f_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_tags` (
                          `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) NOT NULL,
                          `slug` varchar(100) NOT NULL,
                          `description` text DEFAULT NULL,
                          `color` varchar(50) DEFAULT NULL,
                          `image_url` varchar(255) DEFAULT NULL,
                          `background_path` varchar(100) DEFAULT NULL,
                          `background_mode` varchar(100) DEFAULT NULL,
                          `position` int(11) DEFAULT NULL,
                          `parent_id` int(10) unsigned DEFAULT NULL,
                          `default_sort` varchar(50) DEFAULT NULL,
                          `is_restricted` tinyint(1) NOT NULL DEFAULT 0,
                          `is_hidden` tinyint(1) NOT NULL DEFAULT 0,
                          `discussion_count` int(10) unsigned NOT NULL DEFAULT 0,
                          `last_posted_at` datetime DEFAULT NULL,
                          `last_posted_discussion_id` int(10) unsigned DEFAULT NULL,
                          `last_posted_user_id` int(10) unsigned DEFAULT NULL,
                          `icon` varchar(100) DEFAULT NULL,
                          `created_at` timestamp NULL DEFAULT current_timestamp(),
                          `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                          `post_count` int(10) unsigned NOT NULL DEFAULT 0,
                          `is_qna` tinyint(1) NOT NULL DEFAULT 0,
                          `qna_reminders` tinyint(1) NOT NULL DEFAULT 0,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `f_tags_slug_unique` (`slug`),
                          KEY `f_tags_parent_id_foreign` (`parent_id`),
                          KEY `f_tags_last_posted_user_id_foreign` (`last_posted_user_id`),
                          KEY `f_tags_last_posted_discussion_id_foreign` (`last_posted_discussion_id`),
                          CONSTRAINT `f_tags_last_posted_discussion_id_foreign` FOREIGN KEY (`last_posted_discussion_id`) REFERENCES `f_discussions` (`id`) ON DELETE SET NULL,
                          CONSTRAINT `f_tags_last_posted_user_id_foreign` FOREIGN KEY (`last_posted_user_id`) REFERENCES `f_users` (`id`) ON DELETE SET NULL,
                          CONSTRAINT `f_tags_parent_id_foreign` FOREIGN KEY (`parent_id`) REFERENCES `f_tags` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `f_users` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `username` varchar(100) NOT NULL,
                           `nickname` varchar(255) DEFAULT NULL,
                           `email` varchar(254) NOT NULL,
                           `is_email_confirmed` tinyint(1) NOT NULL DEFAULT 0,
                           `password` varchar(100) NOT NULL,
                           `avatar_url` varchar(100) DEFAULT NULL,
                           `preferences` blob DEFAULT NULL,
                           `joined_at` datetime DEFAULT NULL,
                           `last_seen_at` datetime DEFAULT NULL,
                           `marked_all_as_read_at` datetime DEFAULT NULL,
                           `read_notifications_at` datetime DEFAULT NULL,
                           `discussion_count` int(10) unsigned NOT NULL DEFAULT 0,
                           `comment_count` int(10) unsigned NOT NULL DEFAULT 0,
                           `read_flags_at` datetime DEFAULT NULL,
                           `suspended_until` datetime DEFAULT NULL,
                           `suspend_reason` text DEFAULT NULL,
                           `suspend_message` text DEFAULT NULL,
                           `money` double NOT NULL DEFAULT 0,
                           `best_answer_count` int(10) unsigned DEFAULT NULL,
                           `votes` int(11) NOT NULL,
                           `rank` varchar(255) DEFAULT NULL,
                           `last_vote_time` datetime DEFAULT NULL,
                           `bio` text DEFAULT NULL,
                           `cover` varchar(150) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `f_users_username_unique` (`username`),
                           UNIQUE KEY `f_users_email_unique` (`email`),
                           KEY `f_users_joined_at_index` (`joined_at`),
                           KEY `f_users_last_seen_at_index` (`last_seen_at`),
                           KEY `f_users_discussion_count_index` (`discussion_count`),
                           KEY `f_users_comment_count_index` (`comment_count`),
                           KEY `f_users_nickname_index` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
