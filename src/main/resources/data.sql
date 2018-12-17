insert into CATEGORY (NAME ,DESCRIPTION ) values
('zupy', 'pierwsze dania'),
('dania główne', 'drugie dania'),
('desery', 'desery i słodycze'),
('drinki','napoje alkoholowe');

insert into RECIPE  (NAME ,DESCRIPTION, PHOTOURL ) values
('schabowy', 'mięso', 'http://url'),
('ogórkowa', 'z ogórków', 'http://url'),
('lody', 'różne smaki', 'http://url');

insert into CATEGORY_RECIPES values
(2,1),
(1,2),
(3,3);