package MetroCredit;

import java.util.List;
import java.util.Map;

public class TramTest {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        init(customerManager);


        // test o day nha
        var t1 = customerManager.getCreditsByType(Type.ONE_WAY);
        var t2 = customerManager.getCustomer(2).totalCredit();
        System.out.println(t2);
    }

    public static <E> void printData(List<E> data) {
        data.forEach(System.out::println);
    }

    public static <K, V> void printData(Map<K, V> data) {
        data.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

    public static void init(CustomerManager customerManager) {
        // Customer 1: 20 credits
        customerManager.addCustomer(1L, "Nguyen Van A", 25);
        Customer c1 = customerManager.getCustomerById(1L);
        c1.addCredit(1L, Type.ONE_WAY, Location.SUOI_TIEN, Location.BEN_THANH);
        c1.addCredit(2L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.THAO_DIEN);
        c1.addCredit(3L, Type.ONE_WAY, Location.THU_DUC, Location.TAN_CANG);
        c1.addCredit(4L, Type.TWO_WAYS, Location.BINH_THAI, Location.BA_SON);
        c1.addCredit(5L, Type.ONE_WAY, Location.PHUOC_LONG, Location.AN_PHU);
        c1.addCredit(6L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.VAN_THANH);
        c1.addCredit(7L, Type.ONE_WAY, Location.AN_PHU, Location.BEN_THANH);
        c1.addCredit(8L, Type.TWO_WAYS, Location.THAO_DIEN, Location.SUOI_TIEN);
        c1.addCredit(9L, Type.ONE_WAY, Location.TAN_CANG, Location.DAI_HOC_QUOC_GIA);
        c1.addCredit(10L, Type.TWO_WAYS, Location.VAN_THANH, Location.THU_DUC);
        c1.addCredit(11L, Type.ONE_WAY, Location.BA_SON, Location.BINH_THAI);
        c1.addCredit(12L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.PHUOC_LONG);
        c1.addCredit(13L, Type.ONE_WAY, Location.BEN_THANH, Location.RACH_CHIEC);
        c1.addCredit(14L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.AN_PHU);
        c1.addCredit(15L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.THAO_DIEN);
        c1.addCredit(16L, Type.TWO_WAYS, Location.THU_DUC, Location.TAN_CANG);
        c1.addCredit(17L, Type.ONE_WAY, Location.BINH_THAI, Location.VAN_THANH);
        c1.addCredit(18L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.BA_SON);
        c1.addCredit(19L, Type.ONE_WAY, Location.RACH_CHIEC, Location.NHA_HAT_THANH_PHO);
        c1.addCredit(20L, Type.TWO_WAYS, Location.AN_PHU, Location.BEN_THANH);

        // Customer 2: 22 credits
        customerManager.addCustomer(2L, "Tran Thi B", 30);
        Customer c2 = customerManager.getCustomerById(2L);
        c2.addCredit(21L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        c2.addCredit(22L, Type.TWO_WAYS, Location.THAO_DIEN, Location.DAI_HOC_QUOC_GIA);
        c2.addCredit(23L, Type.ONE_WAY, Location.TAN_CANG, Location.THU_DUC);
        c2.addCredit(24L, Type.TWO_WAYS, Location.BA_SON, Location.BINH_THAI);
        c2.addCredit(25L, Type.ONE_WAY, Location.AN_PHU, Location.PHUOC_LONG);
        c2.addCredit(26L, Type.TWO_WAYS, Location.VAN_THANH, Location.RACH_CHIEC);
        c2.addCredit(27L, Type.ONE_WAY, Location.BEN_THANH, Location.AN_PHU);
        c2.addCredit(28L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.THAO_DIEN);
        c2.addCredit(29L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.TAN_CANG);
        c2.addCredit(30L, Type.TWO_WAYS, Location.THU_DUC, Location.VAN_THANH);
        c2.addCredit(31L, Type.ONE_WAY, Location.BINH_THAI, Location.BA_SON);
        c2.addCredit(32L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.NHA_HAT_THANH_PHO);
        c2.addCredit(33L, Type.ONE_WAY, Location.RACH_CHIEC, Location.BEN_THANH);
        c2.addCredit(34L, Type.TWO_WAYS, Location.AN_PHU, Location.SUOI_TIEN);
        c2.addCredit(35L, Type.ONE_WAY, Location.THAO_DIEN, Location.DAI_HOC_QUOC_GIA);
        c2.addCredit(36L, Type.TWO_WAYS, Location.TAN_CANG, Location.THU_DUC);
        c2.addCredit(37L, Type.ONE_WAY, Location.VAN_THANH, Location.BINH_THAI);
        c2.addCredit(38L, Type.TWO_WAYS, Location.BA_SON, Location.PHUOC_LONG);
        c2.addCredit(39L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.RACH_CHIEC);
        c2.addCredit(40L, Type.TWO_WAYS, Location.BEN_THANH, Location.AN_PHU);
        c2.addCredit(41L, Type.ONE_WAY, Location.SUOI_TIEN, Location.THAO_DIEN);
        c2.addCredit(42L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.TAN_CANG);

        // Customer 3: 24 credits
        customerManager.addCustomer(3L, "Le Van C", 28);
        Customer c3 = customerManager.getCustomerById(3L);
        c3.addCredit(43L, Type.ONE_WAY, Location.THU_DUC, Location.BEN_THANH);
        c3.addCredit(44L, Type.TWO_WAYS, Location.BINH_THAI, Location.SUOI_TIEN);
        c3.addCredit(45L, Type.ONE_WAY, Location.PHUOC_LONG, Location.DAI_HOC_QUOC_GIA);
        c3.addCredit(46L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.THAO_DIEN);
        c3.addCredit(47L, Type.ONE_WAY, Location.AN_PHU, Location.TAN_CANG);
        c3.addCredit(48L, Type.TWO_WAYS, Location.THAO_DIEN, Location.VAN_THANH);
        c3.addCredit(49L, Type.ONE_WAY, Location.TAN_CANG, Location.BA_SON);
        c3.addCredit(50L, Type.TWO_WAYS, Location.VAN_THANH, Location.NHA_HAT_THANH_PHO);
        c3.addCredit(51L, Type.ONE_WAY, Location.BA_SON, Location.BEN_THANH);
        c3.addCredit(52L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.SUOI_TIEN);
        c3.addCredit(53L, Type.ONE_WAY, Location.BEN_THANH, Location.DAI_HOC_QUOC_GIA);
        c3.addCredit(54L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.THU_DUC);
        c3.addCredit(55L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.BINH_THAI);
        c3.addCredit(56L, Type.TWO_WAYS, Location.THU_DUC, Location.PHUOC_LONG);
        c3.addCredit(57L, Type.ONE_WAY, Location.BINH_THAI, Location.RACH_CHIEC);
        c3.addCredit(58L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.AN_PHU);
        c3.addCredit(59L, Type.ONE_WAY, Location.RACH_CHIEC, Location.THAO_DIEN);
        c3.addCredit(60L, Type.TWO_WAYS, Location.AN_PHU, Location.TAN_CANG);
        c3.addCredit(61L, Type.ONE_WAY, Location.THAO_DIEN, Location.VAN_THANH);
        c3.addCredit(62L, Type.TWO_WAYS, Location.TAN_CANG, Location.BA_SON);
        c3.addCredit(63L, Type.ONE_WAY, Location.VAN_THANH, Location.NHA_HAT_THANH_PHO);
        c3.addCredit(64L, Type.TWO_WAYS, Location.BA_SON, Location.BEN_THANH);
        c3.addCredit(65L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.SUOI_TIEN);
        c3.addCredit(66L, Type.TWO_WAYS, Location.BEN_THANH, Location.DAI_HOC_QUOC_GIA);

        // Customer 4: 26 credits
        customerManager.addCustomer(4L, "Pham Thi D", 35);
        Customer c4 = customerManager.getCustomerById(4L);
        c4.addCredit(67L, Type.ONE_WAY, Location.SUOI_TIEN, Location.THU_DUC);
        c4.addCredit(68L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.BINH_THAI);
        c4.addCredit(69L, Type.ONE_WAY, Location.THU_DUC, Location.PHUOC_LONG);
        c4.addCredit(70L, Type.TWO_WAYS, Location.BINH_THAI, Location.RACH_CHIEC);
        c4.addCredit(71L, Type.ONE_WAY, Location.PHUOC_LONG, Location.AN_PHU);
        c4.addCredit(72L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.THAO_DIEN);
        c4.addCredit(73L, Type.ONE_WAY, Location.AN_PHU, Location.TAN_CANG);
        c4.addCredit(74L, Type.TWO_WAYS, Location.THAO_DIEN, Location.VAN_THANH);
        c4.addCredit(75L, Type.ONE_WAY, Location.TAN_CANG, Location.BA_SON);
        c4.addCredit(76L, Type.TWO_WAYS, Location.VAN_THANH, Location.NHA_HAT_THANH_PHO);
        c4.addCredit(77L, Type.ONE_WAY, Location.BA_SON, Location.BEN_THANH);
        c4.addCredit(78L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.SUOI_TIEN);
        c4.addCredit(79L, Type.ONE_WAY, Location.BEN_THANH, Location.DAI_HOC_QUOC_GIA);
        c4.addCredit(80L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.THU_DUC);
        c4.addCredit(81L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.BINH_THAI);
        c4.addCredit(82L, Type.TWO_WAYS, Location.THU_DUC, Location.PHUOC_LONG);
        c4.addCredit(83L, Type.ONE_WAY, Location.BINH_THAI, Location.RACH_CHIEC);
        c4.addCredit(84L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.AN_PHU);
        c4.addCredit(85L, Type.ONE_WAY, Location.RACH_CHIEC, Location.THAO_DIEN);
        c4.addCredit(86L, Type.TWO_WAYS, Location.AN_PHU, Location.TAN_CANG);
        c4.addCredit(87L, Type.ONE_WAY, Location.THAO_DIEN, Location.VAN_THANH);
        c4.addCredit(88L, Type.TWO_WAYS, Location.TAN_CANG, Location.BA_SON);
        c4.addCredit(89L, Type.ONE_WAY, Location.VAN_THANH, Location.NHA_HAT_THANH_PHO);
        c4.addCredit(90L, Type.TWO_WAYS, Location.BA_SON, Location.BEN_THANH);
        c4.addCredit(91L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.SUOI_TIEN);
        c4.addCredit(92L, Type.TWO_WAYS, Location.BEN_THANH, Location.DAI_HOC_QUOC_GIA);

        // Customer 5: 28 credits
        customerManager.addCustomer(5L, "Hoang Van E", 40);
        Customer c5 = customerManager.getCustomerById(5L);
        c5.addCredit(93L, Type.ONE_WAY, Location.SUOI_TIEN, Location.BEN_THANH);
        c5.addCredit(94L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.NHA_HAT_THANH_PHO);
        c5.addCredit(95L, Type.ONE_WAY, Location.THU_DUC, Location.BA_SON);
        c5.addCredit(96L, Type.TWO_WAYS, Location.BINH_THAI, Location.VAN_THANH);
        c5.addCredit(97L, Type.ONE_WAY, Location.PHUOC_LONG, Location.TAN_CANG);
        c5.addCredit(98L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.THAO_DIEN);
        c5.addCredit(99L, Type.ONE_WAY, Location.AN_PHU, Location.RACH_CHIEC);
        c5.addCredit(100L, Type.TWO_WAYS, Location.THAO_DIEN, Location.PHUOC_LONG);
        c5.addCredit(101L, Type.ONE_WAY, Location.TAN_CANG, Location.BINH_THAI);
        c5.addCredit(102L, Type.TWO_WAYS, Location.VAN_THANH, Location.THU_DUC);
        c5.addCredit(103L, Type.ONE_WAY, Location.BA_SON, Location.DAI_HOC_QUOC_GIA);
        c5.addCredit(104L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.SUOI_TIEN);
        c5.addCredit(105L, Type.ONE_WAY, Location.BEN_THANH, Location.AN_PHU);
        c5.addCredit(106L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.THAO_DIEN);
        c5.addCredit(107L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.TAN_CANG);
        c5.addCredit(108L, Type.TWO_WAYS, Location.THU_DUC, Location.VAN_THANH);
        c5.addCredit(109L, Type.ONE_WAY, Location.BINH_THAI, Location.BA_SON);
        c5.addCredit(110L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.NHA_HAT_THANH_PHO);
        c5.addCredit(111L, Type.ONE_WAY, Location.RACH_CHIEC, Location.BEN_THANH);
        c5.addCredit(112L, Type.TWO_WAYS, Location.AN_PHU, Location.SUOI_TIEN);
        c5.addCredit(113L, Type.ONE_WAY, Location.THAO_DIEN, Location.DAI_HOC_QUOC_GIA);
        c5.addCredit(114L, Type.TWO_WAYS, Location.TAN_CANG, Location.THU_DUC);
        c5.addCredit(115L, Type.ONE_WAY, Location.VAN_THANH, Location.BINH_THAI);
        c5.addCredit(116L, Type.TWO_WAYS, Location.BA_SON, Location.PHUOC_LONG);
        c5.addCredit(117L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.RACH_CHIEC);
        c5.addCredit(118L, Type.TWO_WAYS, Location.BEN_THANH, Location.AN_PHU);
        c5.addCredit(119L, Type.ONE_WAY, Location.SUOI_TIEN, Location.THAO_DIEN);
        c5.addCredit(120L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.TAN_CANG);

        // Customer 6: 30 credits
        customerManager.addCustomer(6L, "Vo Thi F", 32);
        Customer c6 = customerManager.getCustomerById(6L);
        c6.addCredit(121L, Type.ONE_WAY, Location.THU_DUC, Location.BEN_THANH);
        c6.addCredit(122L, Type.TWO_WAYS, Location.BINH_THAI, Location.NHA_HAT_THANH_PHO);
        c6.addCredit(123L, Type.ONE_WAY, Location.PHUOC_LONG, Location.BA_SON);
        c6.addCredit(124L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.VAN_THANH);
        c6.addCredit(125L, Type.ONE_WAY, Location.AN_PHU, Location.TAN_CANG);
        c6.addCredit(126L, Type.TWO_WAYS, Location.THAO_DIEN, Location.PHUOC_LONG);
        c6.addCredit(127L, Type.ONE_WAY, Location.TAN_CANG, Location.RACH_CHIEC);
        c6.addCredit(128L, Type.TWO_WAYS, Location.VAN_THANH, Location.AN_PHU);
        c6.addCredit(129L, Type.ONE_WAY, Location.BA_SON, Location.THAO_DIEN);
        c6.addCredit(130L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.TAN_CANG);
        c6.addCredit(131L, Type.ONE_WAY, Location.BEN_THANH, Location.VAN_THANH);
        c6.addCredit(132L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.BA_SON);
        c6.addCredit(133L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.NHA_HAT_THANH_PHO);
        c6.addCredit(134L, Type.TWO_WAYS, Location.THU_DUC, Location.BEN_THANH);
        c6.addCredit(135L, Type.ONE_WAY, Location.BINH_THAI, Location.SUOI_TIEN);
        c6.addCredit(136L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.DAI_HOC_QUOC_GIA);
        c6.addCredit(137L, Type.ONE_WAY, Location.RACH_CHIEC, Location.THU_DUC);
        c6.addCredit(138L, Type.TWO_WAYS, Location.AN_PHU, Location.BINH_THAI);
        c6.addCredit(139L, Type.ONE_WAY, Location.THAO_DIEN, Location.PHUOC_LONG);
        c6.addCredit(140L, Type.TWO_WAYS, Location.TAN_CANG, Location.RACH_CHIEC);
        c6.addCredit(141L, Type.ONE_WAY, Location.VAN_THANH, Location.AN_PHU);
        c6.addCredit(142L, Type.TWO_WAYS, Location.BA_SON, Location.THAO_DIEN);
        c6.addCredit(143L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.TAN_CANG);
        c6.addCredit(144L, Type.TWO_WAYS, Location.BEN_THANH, Location.VAN_THANH);
        c6.addCredit(145L, Type.ONE_WAY, Location.SUOI_TIEN, Location.BA_SON);
        c6.addCredit(146L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.NHA_HAT_THANH_PHO);
        c6.addCredit(147L, Type.ONE_WAY, Location.THU_DUC, Location.BEN_THANH);
        c6.addCredit(148L, Type.TWO_WAYS, Location.BINH_THAI, Location.SUOI_TIEN);
        c6.addCredit(149L, Type.ONE_WAY, Location.PHUOC_LONG, Location.DAI_HOC_QUOC_GIA);
        c6.addCredit(150L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.THU_DUC);

        // Customer 7: 20 credits
        customerManager.addCustomer(7L, "Dang Van G", 27);
        Customer c7 = customerManager.getCustomerById(7L);
        c7.addCredit(151L, Type.ONE_WAY, Location.AN_PHU, Location.BEN_THANH);
        c7.addCredit(152L, Type.TWO_WAYS, Location.THAO_DIEN, Location.SUOI_TIEN);
        c7.addCredit(153L, Type.ONE_WAY, Location.TAN_CANG, Location.DAI_HOC_QUOC_GIA);
        c7.addCredit(154L, Type.TWO_WAYS, Location.VAN_THANH, Location.THU_DUC);
        c7.addCredit(155L, Type.ONE_WAY, Location.BA_SON, Location.BINH_THAI);
        c7.addCredit(156L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.PHUOC_LONG);
        c7.addCredit(157L, Type.ONE_WAY, Location.BEN_THANH, Location.RACH_CHIEC);
        c7.addCredit(158L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.AN_PHU);
        c7.addCredit(159L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.THAO_DIEN);
        c7.addCredit(160L, Type.TWO_WAYS, Location.THU_DUC, Location.TAN_CANG);
        c7.addCredit(161L, Type.ONE_WAY, Location.BINH_THAI, Location.VAN_THANH);
        c7.addCredit(162L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.BA_SON);
        c7.addCredit(163L, Type.ONE_WAY, Location.RACH_CHIEC, Location.NHA_HAT_THANH_PHO);
        c7.addCredit(164L, Type.TWO_WAYS, Location.AN_PHU, Location.BEN_THANH);
        c7.addCredit(165L, Type.ONE_WAY, Location.THAO_DIEN, Location.SUOI_TIEN);
        c7.addCredit(166L, Type.TWO_WAYS, Location.TAN_CANG, Location.DAI_HOC_QUOC_GIA);
        c7.addCredit(167L, Type.ONE_WAY, Location.VAN_THANH, Location.THU_DUC);
        c7.addCredit(168L, Type.TWO_WAYS, Location.BA_SON, Location.BINH_THAI);
        c7.addCredit(169L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.PHUOC_LONG);
        c7.addCredit(170L, Type.TWO_WAYS, Location.BEN_THANH, Location.RACH_CHIEC);

        // Customer 8: 22 credits
        customerManager.addCustomer(8L, "Bui Thi H", 29);
        Customer c8 = customerManager.getCustomerById(8L);
        c8.addCredit(171L, Type.ONE_WAY, Location.SUOI_TIEN, Location.AN_PHU);
        c8.addCredit(172L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.THAO_DIEN);
        c8.addCredit(173L, Type.ONE_WAY, Location.THU_DUC, Location.TAN_CANG);
        c8.addCredit(174L, Type.TWO_WAYS, Location.BINH_THAI, Location.VAN_THANH);
        c8.addCredit(175L, Type.ONE_WAY, Location.PHUOC_LONG, Location.BA_SON);
        c8.addCredit(176L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.NHA_HAT_THANH_PHO);
        c8.addCredit(177L, Type.ONE_WAY, Location.AN_PHU, Location.BEN_THANH);
        c8.addCredit(178L, Type.TWO_WAYS, Location.THAO_DIEN, Location.SUOI_TIEN);
        c8.addCredit(179L, Type.ONE_WAY, Location.TAN_CANG, Location.DAI_HOC_QUOC_GIA);
        c8.addCredit(180L, Type.TWO_WAYS, Location.VAN_THANH, Location.THU_DUC);
        c8.addCredit(181L, Type.ONE_WAY, Location.BA_SON, Location.BINH_THAI);
        c8.addCredit(182L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.PHUOC_LONG);
        c8.addCredit(183L, Type.ONE_WAY, Location.BEN_THANH, Location.RACH_CHIEC);
        c8.addCredit(184L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.AN_PHU);
        c8.addCredit(185L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.THAO_DIEN);
        c8.addCredit(186L, Type.TWO_WAYS, Location.THU_DUC, Location.TAN_CANG);
        c8.addCredit(187L, Type.ONE_WAY, Location.BINH_THAI, Location.VAN_THANH);
        c8.addCredit(188L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.BA_SON);
        c8.addCredit(189L, Type.ONE_WAY, Location.RACH_CHIEC, Location.NHA_HAT_THANH_PHO);
        c8.addCredit(190L, Type.TWO_WAYS, Location.AN_PHU, Location.BEN_THANH);
        c8.addCredit(191L, Type.ONE_WAY, Location.THAO_DIEN, Location.SUOI_TIEN);
        c8.addCredit(192L, Type.TWO_WAYS, Location.TAN_CANG, Location.DAI_HOC_QUOC_GIA);

        // Customer 9: 24 credits
        customerManager.addCustomer(9L, "Ngo Van I", 33);
        Customer c9 = customerManager.getCustomerById(9L);
        c9.addCredit(193L, Type.ONE_WAY, Location.VAN_THANH, Location.BEN_THANH);
        c9.addCredit(194L, Type.TWO_WAYS, Location.BA_SON, Location.SUOI_TIEN);
        c9.addCredit(195L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.DAI_HOC_QUOC_GIA);
        c9.addCredit(196L, Type.TWO_WAYS, Location.BEN_THANH, Location.THU_DUC);
        c9.addCredit(197L, Type.ONE_WAY, Location.SUOI_TIEN, Location.BINH_THAI);
        c9.addCredit(198L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.PHUOC_LONG);
        c9.addCredit(199L, Type.ONE_WAY, Location.THU_DUC, Location.RACH_CHIEC);
        c9.addCredit(200L, Type.TWO_WAYS, Location.BINH_THAI, Location.AN_PHU);
        c9.addCredit(201L, Type.ONE_WAY, Location.PHUOC_LONG, Location.THAO_DIEN);
        c9.addCredit(202L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.TAN_CANG);
        c9.addCredit(203L, Type.ONE_WAY, Location.AN_PHU, Location.VAN_THANH);
        c9.addCredit(204L, Type.TWO_WAYS, Location.THAO_DIEN, Location.BA_SON);
        c9.addCredit(205L, Type.ONE_WAY, Location.TAN_CANG, Location.NHA_HAT_THANH_PHO);
        c9.addCredit(206L, Type.TWO_WAYS, Location.VAN_THANH, Location.BEN_THANH);
        c9.addCredit(207L, Type.ONE_WAY, Location.BA_SON, Location.SUOI_TIEN);
        c9.addCredit(208L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.DAI_HOC_QUOC_GIA);
        c9.addCredit(209L, Type.ONE_WAY, Location.BEN_THANH, Location.THU_DUC);
        c9.addCredit(210L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.BINH_THAI);
        c9.addCredit(211L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.PHUOC_LONG);
        c9.addCredit(212L, Type.TWO_WAYS, Location.THU_DUC, Location.RACH_CHIEC);
        c9.addCredit(213L, Type.ONE_WAY, Location.BINH_THAI, Location.AN_PHU);
        c9.addCredit(214L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.THAO_DIEN);
        c9.addCredit(215L, Type.ONE_WAY, Location.RACH_CHIEC, Location.TAN_CANG);
        c9.addCredit(216L, Type.TWO_WAYS, Location.AN_PHU, Location.VAN_THANH);

        // Customer 10: 26 credits
        customerManager.addCustomer(10L, "Do Thi K", 38);
        Customer c10 = customerManager.getCustomerById(10L);
        c10.addCredit(217L, Type.ONE_WAY, Location.THAO_DIEN, Location.BEN_THANH);
        c10.addCredit(218L, Type.TWO_WAYS, Location.TAN_CANG, Location.SUOI_TIEN);
        c10.addCredit(219L, Type.ONE_WAY, Location.VAN_THANH, Location.DAI_HOC_QUOC_GIA);
        c10.addCredit(220L, Type.TWO_WAYS, Location.BA_SON, Location.THU_DUC);
        c10.addCredit(221L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.BINH_THAI);
        c10.addCredit(222L, Type.TWO_WAYS, Location.BEN_THANH, Location.PHUOC_LONG);
        c10.addCredit(223L, Type.ONE_WAY, Location.SUOI_TIEN, Location.RACH_CHIEC);
        c10.addCredit(224L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.AN_PHU);
        c10.addCredit(225L, Type.ONE_WAY, Location.THU_DUC, Location.THAO_DIEN);
        c10.addCredit(226L, Type.TWO_WAYS, Location.BINH_THAI, Location.TAN_CANG);
        c10.addCredit(227L, Type.ONE_WAY, Location.PHUOC_LONG, Location.VAN_THANH);
        c10.addCredit(228L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.BA_SON);
        c10.addCredit(229L, Type.ONE_WAY, Location.AN_PHU, Location.NHA_HAT_THANH_PHO);
        c10.addCredit(230L, Type.TWO_WAYS, Location.THAO_DIEN, Location.BEN_THANH);
        c10.addCredit(231L, Type.ONE_WAY, Location.TAN_CANG, Location.SUOI_TIEN);
        c10.addCredit(232L, Type.TWO_WAYS, Location.VAN_THANH, Location.DAI_HOC_QUOC_GIA);
        c10.addCredit(233L, Type.ONE_WAY, Location.BA_SON, Location.THU_DUC);
        c10.addCredit(234L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.BINH_THAI);
        c10.addCredit(235L, Type.ONE_WAY, Location.BEN_THANH, Location.PHUOC_LONG);
        c10.addCredit(236L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.RACH_CHIEC);
        c10.addCredit(237L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.AN_PHU);
        c10.addCredit(238L, Type.TWO_WAYS, Location.THU_DUC, Location.THAO_DIEN);
        c10.addCredit(239L, Type.ONE_WAY, Location.BINH_THAI, Location.TAN_CANG);
        c10.addCredit(240L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.VAN_THANH);
        c10.addCredit(241L, Type.ONE_WAY, Location.RACH_CHIEC, Location.BA_SON);
        c10.addCredit(242L, Type.TWO_WAYS, Location.AN_PHU, Location.NHA_HAT_THANH_PHO);

        // Customer 11-50: Continue with similar pattern...
        // Customer 11: 28 credits
        customerManager.addCustomer(11L, "Truong Van L", 26);
        Customer c11 = customerManager.getCustomerById(11L);
        c11.addCredit(243L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        c11.addCredit(244L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.DAI_HOC_QUOC_GIA);
        c11.addCredit(245L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.THU_DUC);
        c11.addCredit(246L, Type.TWO_WAYS, Location.THU_DUC, Location.BINH_THAI);
        c11.addCredit(247L, Type.ONE_WAY, Location.BINH_THAI, Location.PHUOC_LONG);
        c11.addCredit(248L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.RACH_CHIEC);
        c11.addCredit(249L, Type.ONE_WAY, Location.RACH_CHIEC, Location.AN_PHU);
        c11.addCredit(250L, Type.TWO_WAYS, Location.AN_PHU, Location.THAO_DIEN);
        c11.addCredit(251L, Type.ONE_WAY, Location.THAO_DIEN, Location.TAN_CANG);
        c11.addCredit(252L, Type.TWO_WAYS, Location.TAN_CANG, Location.VAN_THANH);
        c11.addCredit(253L, Type.ONE_WAY, Location.VAN_THANH, Location.BA_SON);
        c11.addCredit(254L, Type.TWO_WAYS, Location.BA_SON, Location.NHA_HAT_THANH_PHO);
        c11.addCredit(255L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.BEN_THANH);
        c11.addCredit(256L, Type.TWO_WAYS, Location.BEN_THANH, Location.SUOI_TIEN);
        c11.addCredit(257L, Type.ONE_WAY, Location.SUOI_TIEN, Location.DAI_HOC_QUOC_GIA);
        c11.addCredit(258L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.THU_DUC);
        c11.addCredit(259L, Type.ONE_WAY, Location.THU_DUC, Location.BINH_THAI);
        c11.addCredit(260L, Type.TWO_WAYS, Location.BINH_THAI, Location.PHUOC_LONG);
        c11.addCredit(261L, Type.ONE_WAY, Location.PHUOC_LONG, Location.RACH_CHIEC);
        c11.addCredit(262L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.AN_PHU);
        c11.addCredit(263L, Type.ONE_WAY, Location.AN_PHU, Location.THAO_DIEN);
        c11.addCredit(264L, Type.TWO_WAYS, Location.THAO_DIEN, Location.TAN_CANG);
        c11.addCredit(265L, Type.ONE_WAY, Location.TAN_CANG, Location.VAN_THANH);
        c11.addCredit(266L, Type.TWO_WAYS, Location.VAN_THANH, Location.BA_SON);
        c11.addCredit(267L, Type.ONE_WAY, Location.BA_SON, Location.NHA_HAT_THANH_PHO);
        c11.addCredit(268L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.BEN_THANH);
        c11.addCredit(269L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        c11.addCredit(270L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.DAI_HOC_QUOC_GIA);

        // Customer 12: 30 credits
        customerManager.addCustomer(12L, "Ly Thi M", 31);
        Customer c12 = customerManager.getCustomerById(12L);
        c12.addCredit(271L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.BEN_THANH);
        c12.addCredit(272L, Type.TWO_WAYS, Location.THU_DUC, Location.SUOI_TIEN);
        c12.addCredit(273L, Type.ONE_WAY, Location.BINH_THAI, Location.DAI_HOC_QUOC_GIA);
        c12.addCredit(274L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.THU_DUC);
        c12.addCredit(275L, Type.ONE_WAY, Location.RACH_CHIEC, Location.BINH_THAI);
        c12.addCredit(276L, Type.TWO_WAYS, Location.AN_PHU, Location.PHUOC_LONG);
        c12.addCredit(277L, Type.ONE_WAY, Location.THAO_DIEN, Location.RACH_CHIEC);
        c12.addCredit(278L, Type.TWO_WAYS, Location.TAN_CANG, Location.AN_PHU);
        c12.addCredit(279L, Type.ONE_WAY, Location.VAN_THANH, Location.THAO_DIEN);
        c12.addCredit(280L, Type.TWO_WAYS, Location.BA_SON, Location.TAN_CANG);
        c12.addCredit(281L, Type.ONE_WAY, Location.NHA_HAT_THANH_PHO, Location.VAN_THANH);
        c12.addCredit(282L, Type.TWO_WAYS, Location.BEN_THANH, Location.BA_SON);
        c12.addCredit(283L, Type.ONE_WAY, Location.SUOI_TIEN, Location.NHA_HAT_THANH_PHO);
        c12.addCredit(284L, Type.TWO_WAYS, Location.DAI_HOC_QUOC_GIA, Location.BEN_THANH);
        c12.addCredit(285L, Type.ONE_WAY, Location.THU_DUC, Location.SUOI_TIEN);
        c12.addCredit(286L, Type.TWO_WAYS, Location.BINH_THAI, Location.DAI_HOC_QUOC_GIA);
        c12.addCredit(287L, Type.ONE_WAY, Location.PHUOC_LONG, Location.THU_DUC);
        c12.addCredit(288L, Type.TWO_WAYS, Location.RACH_CHIEC, Location.BINH_THAI);
        c12.addCredit(289L, Type.ONE_WAY, Location.AN_PHU, Location.PHUOC_LONG);
        c12.addCredit(290L, Type.TWO_WAYS, Location.THAO_DIEN, Location.RACH_CHIEC);
        c12.addCredit(291L, Type.ONE_WAY, Location.TAN_CANG, Location.AN_PHU);
        c12.addCredit(292L, Type.TWO_WAYS, Location.VAN_THANH, Location.THAO_DIEN);
        c12.addCredit(293L, Type.ONE_WAY, Location.BA_SON, Location.TAN_CANG);
        c12.addCredit(294L, Type.TWO_WAYS, Location.NHA_HAT_THANH_PHO, Location.VAN_THANH);
        c12.addCredit(295L, Type.ONE_WAY, Location.BEN_THANH, Location.BA_SON);
        c12.addCredit(296L, Type.TWO_WAYS, Location.SUOI_TIEN, Location.NHA_HAT_THANH_PHO);
        c12.addCredit(297L, Type.ONE_WAY, Location.DAI_HOC_QUOC_GIA, Location.BEN_THANH);
        c12.addCredit(298L, Type.TWO_WAYS, Location.THU_DUC, Location.SUOI_TIEN);
        c12.addCredit(299L, Type.ONE_WAY, Location.BINH_THAI, Location.DAI_HOC_QUOC_GIA);
        c12.addCredit(300L, Type.TWO_WAYS, Location.PHUOC_LONG, Location.THU_DUC);

        // Customers 13-50 with varying credit counts (20-30)
        // Customer 13: 21 credits
        customerManager.addCustomer(13L, "Mai Van N", 34);
        Customer c13 = customerManager.getCustomerById(13L);
        for (int i = 0; i < 21; i++) {
            c13.addCredit(301L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[i % 13], Location.values()[(i + 5) % 13]);
        }

        // Customer 14: 23 credits
        customerManager.addCustomer(14L, "Phan Thi O", 29);
        Customer c14 = customerManager.getCustomerById(14L);
        for (int i = 0; i < 23; i++) {
            c14.addCredit(322L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 1) % 13], Location.values()[(i + 6) % 13]);
        }

        // Customer 15: 25 credits
        customerManager.addCustomer(15L, "Cao Van P", 36);
        Customer c15 = customerManager.getCustomerById(15L);
        for (int i = 0; i < 25; i++) {
            c15.addCredit(345L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 2) % 13], Location.values()[(i + 7) % 13]);
        }

        // Customer 16: 27 credits
        customerManager.addCustomer(16L, "Ha Thi Q", 41);
        Customer c16 = customerManager.getCustomerById(16L);
        for (int i = 0; i < 27; i++) {
            c16.addCredit(370L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 3) % 13], Location.values()[(i + 8) % 13]);
        }

        // Customer 17: 29 credits
        customerManager.addCustomer(17L, "Duong Van R", 28);
        Customer c17 = customerManager.getCustomerById(17L);
        for (int i = 0; i < 29; i++) {
            c17.addCredit(397L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 4) % 13], Location.values()[(i + 9) % 13]);
        }

        // Customer 18: 20 credits
        customerManager.addCustomer(18L, "Tang Thi S", 33);
        Customer c18 = customerManager.getCustomerById(18L);
        for (int i = 0; i < 20; i++) {
            c18.addCredit(426L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[i % 13], Location.values()[(i + 4) % 13]);
        }

        // Customer 19: 22 credits
        customerManager.addCustomer(19L, "Lam Van T", 37);
        Customer c19 = customerManager.getCustomerById(19L);
        for (int i = 0; i < 22; i++) {
            c19.addCredit(446L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 1) % 13], Location.values()[(i + 5) % 13]);
        }

        // Customer 20: 24 credits
        customerManager.addCustomer(20L, "Chau Thi U", 42);
        Customer c20 = customerManager.getCustomerById(20L);
        for (int i = 0; i < 24; i++) {
            c20.addCredit(468L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 2) % 13], Location.values()[(i + 6) % 13]);
        }

        // Customer 21: 26 credits
        customerManager.addCustomer(21L, "Dinh Van V", 30);
        Customer c21 = customerManager.getCustomerById(21L);
        for (int i = 0; i < 26; i++) {
            c21.addCredit(492L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 3) % 13], Location.values()[(i + 7) % 13]);
        }

        // Customer 22: 28 credits
        customerManager.addCustomer(22L, "Nghiem Thi W", 35);
        Customer c22 = customerManager.getCustomerById(22L);
        for (int i = 0; i < 28; i++) {
            c22.addCredit(518L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 4) % 13], Location.values()[(i + 8) % 13]);
        }

        // Customer 23: 30 credits
        customerManager.addCustomer(23L, "Quach Van X", 39);
        Customer c23 = customerManager.getCustomerById(23L);
        for (int i = 0; i < 30; i++) {
            c23.addCredit(546L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 5) % 13], Location.values()[(i + 9) % 13]);
        }

        // Customer 24: 21 credits
        customerManager.addCustomer(24L, "Ong Thi Y", 27);
        Customer c24 = customerManager.getCustomerById(24L);
        for (int i = 0; i < 21; i++) {
            c24.addCredit(576L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 6) % 13], Location.values()[(i + 10) % 13]);
        }

        // Customer 25: 23 credits
        customerManager.addCustomer(25L, "Uong Van Z", 44);
        Customer c25 = customerManager.getCustomerById(25L);
        for (int i = 0; i < 23; i++) {
            c25.addCredit(597L + i, i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                Location.values()[(i + 7) % 13], Location.values()[(i + 11) % 13]);
        }

        // Customer 26-50: Continue with loop-based approach for efficiency
        for (int customerId = 26; customerId <= 50; customerId++) {
            String name = "Customer" + customerId;
            int age = 20 + (customerId % 30);
            int numCredits = 20 + (customerId % 11); // 20-30 credits

            customerManager.addCustomer((long) customerId, name, age);
            Customer customer = customerManager.getCustomerById((long) customerId);

            long startCreditId = 620L + ((customerId - 26) * 30);
            for (int i = 0; i < numCredits; i++) {
                customer.addCredit(startCreditId + i,
                    i % 2 == 0 ? Type.ONE_WAY : Type.TWO_WAYS,
                    Location.values()[(customerId + i) % 13],
                    Location.values()[(customerId + i + 5) % 13]);
            }
        }
    }
}
