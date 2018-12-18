insert into CATEGORY (NAME ,DESCRIPTION, PHOTOURL ) values
('zupy', 'pierwsze dania','https://www.kwestiasmaku.com/sites/kwestiasmaku.com/files/zupy.jpg'),
('dania główne', 'drugie dania', 'https://s3.przepisy.pl/przepisy3ii/img/variants/535x0/dania_z_ryzem949613.jpg'),
('desery', 'desery i słodycze','https://www.winiary.pl/image.ashx/deser-a-la-tiramisu.jpg?fileID=226219&width=800&height=1400&frame=False&bg=0&resize=1&crop=0&hRefill=0&vRefill=0&quality=84'),
('drinki','napoje alkoholowe','https://polki.pl/foto/4_3_LARGE/drink-cosmopolitan-180345.jpg');

insert into RECIPE  (NAME ,DESCRIPTION, PHOTOURL, LIKES ) values
('schabowy', 'mięso', 'https://static.smaker.pl/photos/6/3/4/634320b0d13462d3176f0896942fa7f0_110705_57b32fe3190aa_wm.jpg',100),
('mielony', 'mięso', 'http://bi.gazeta.pl/im/e6/4a/11/z18132198Q,Przepis-na-kotlety-mielone--Najlepsze--bo-bez-udzi.jpg',60),
('ogórkowa', 'z ogórków', 'https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2018/04/47914-v-900x556.jpg',40),
('lody', 'różne smaki', 'https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2017/07/15597-v-900x556.jpg',10);

insert into RECIPE_CATEGORIES values
(1,2),
(2,2),
(3,1),
(4,3);