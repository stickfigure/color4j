/*
 * Copyright (c) 2000-2011 Niclas Hedhman.
 *
 * Licensed  under the  Apache License, Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.color4j.colorimetry.illuminants;

import org.color4j.colorimetry.Spectrum;

/**
 * A Spectrum implementation of the CIE Standard illuminant D65.
 */

public class D65 extends Spectrum
{
    private static float[] m_Readings =
        {
            0.034100f, 0.360140f, 0.686180f, 1.012220f, 1.338260f,  // 300-304
            1.664300f, 1.990340f, 2.316380f, 2.642420f, 2.968460f,  // 305-309
            3.294500f, 4.988650f, 6.682800f, 8.376950f, 10.071100f,  // 310-314
            11.765200f, 13.459400f, 15.153500f, 16.847700f, 18.541800f,  // 315-319
            20.236000f, 21.917700f, 23.599500f, 25.281200f, 26.963000f,  // 320-324
            28.644700f, 30.326500f, 32.008200f, 33.690000f, 35.371700f,  // 325-329
            37.053500f, 37.343000f, 37.632600f, 37.922100f, 38.211600f,  // 330-334
            38.501100f, 38.790700f, 39.080200f, 39.369700f, 39.659300f,  // 335-339
            39.948800f, 40.445100f, 40.941400f, 41.437700f, 41.934000f,  // 340-344
            42.430200f, 42.926500f, 43.422800f, 43.919100f, 44.415400f,  // 345-349
            44.911700f, 45.084400f, 45.257000f, 45.429700f, 45.602300f,  // 350-354
            45.775000f, 45.947700f, 46.120300f, 46.293000f, 46.465600f,  // 355-359
            46.638300f, 47.183400f, 47.728500f, 48.273500f, 48.818600f,  // 360-364
            49.363700f, 49.908800f, 50.453900f, 50.998900f, 51.544000f,  // 365-369
            52.089100f, 51.877700f, 51.666400f, 51.455000f, 51.243700f,  // 370-374
            51.032300f, 50.820900f, 50.609600f, 50.398200f, 50.186900f,  // 375-379
            49.975500f, 50.442800f, 50.910000f, 51.377300f, 51.844600f,  // 380-384
            52.311800f, 52.779100f, 53.246400f, 53.713700f, 54.180900f,  // 385-389
            54.648200f, 57.458900f, 60.269500f, 63.080200f, 65.890900f,  // 390-394
            68.701500f, 71.512200f, 74.322900f, 77.133600f, 79.944200f,  // 395-399
            82.754900f, 83.628000f, 84.501100f, 85.374200f, 86.247300f,  // 400-404
            87.120400f, 87.993600f, 88.866700f, 89.739800f, 90.612900f,  // 405-409
            91.486000f, 91.680600f, 91.875200f, 92.069700f, 92.264300f,  // 410-414
            92.458900f, 92.653500f, 92.848100f, 93.042600f, 93.237200f,  // 415-419
            93.431800f, 92.756800f, 92.081900f, 91.406900f, 90.732000f,  // 420-424
            90.057000f, 89.382100f, 88.707100f, 88.032200f, 87.357200f,  // 425-429
            86.682300f, 88.500600f, 90.318800f, 92.137100f, 93.955400f,  // 430-434
            95.773600f, 97.591900f, 99.410200f, 101.228000f, 103.047000f,  // 435-439
            104.865000f, 106.079000f, 107.294000f, 108.508000f, 109.722000f,  // 440-444
            110.936000f, 112.151000f, 113.365000f, 114.579000f, 115.794000f,  // 445-449
            117.008000f, 117.088000f, 117.169000f, 117.249000f, 117.330000f,  // 450-454
            117.410000f, 117.490000f, 117.571000f, 117.651000f, 117.732000f,  // 455-459
            117.812000f, 117.517000f, 117.222000f, 116.927000f, 116.632000f,  // 460-464
            116.336000f, 116.041000f, 115.746000f, 115.451000f, 115.156000f,  // 465-469
            114.861000f, 114.967000f, 115.073000f, 115.180000f, 115.286000f,  // 470-474
            115.392000f, 115.498000f, 115.604000f, 115.711000f, 115.817000f,  // 475-479
            115.923000f, 115.212000f, 114.501000f, 113.789000f, 113.078000f,  // 480-484
            112.367000f, 111.656000f, 110.945000f, 110.233000f, 109.522000f,  // 485-489
            108.811000f, 108.865000f, 108.920000f, 108.974000f, 109.028000f,  // 490-494
            109.082000f, 109.137000f, 109.191000f, 109.245000f, 109.300000f,  // 495-499
            109.354000f, 109.199000f, 109.044000f, 108.888000f, 108.733000f,  // 500-504
            108.578000f, 108.423000f, 108.268000f, 108.112000f, 107.957000f,  // 505-509
            107.802000f, 107.501000f, 107.200000f, 106.898000f, 106.597000f,  // 510-514
            106.296000f, 105.995000f, 105.694000f, 105.392000f, 105.091000f,  // 515-519
            104.790000f, 105.080000f, 105.370000f, 105.660000f, 105.950000f,  // 520-524
            106.239000f, 106.529000f, 106.819000f, 107.109000f, 107.399000f,  // 525-529
            107.689000f, 107.361000f, 107.032000f, 106.704000f, 106.375000f,  // 530-534
            106.047000f, 105.719000f, 105.390000f, 105.062000f, 104.733000f,  // 535-539
            104.405000f, 104.369000f, 104.333000f, 104.297000f, 104.261000f,  // 540-544
            104.225000f, 104.190000f, 104.154000f, 104.118000f, 104.082000f,  // 545-549
            104.046000f, 103.641000f, 103.237000f, 102.832000f, 102.428000f,  // 550-554
            102.023000f, 101.618000f, 101.214000f, 100.809000f, 100.405000f,  // 555-559
            100.000000f, 99.633400f, 99.266800f, 98.900300f, 98.533700f,  // 560-564
            98.167100f, 97.800500f, 97.433900f, 97.067400f, 96.700800f,  // 565-569
            96.334200f, 96.279600f, 96.225000f, 96.170300f, 96.115700f,  // 570-574
            96.061100f, 96.006500f, 95.951900f, 95.897200f, 95.842600f,  // 575-579
            95.788000f, 95.077800f, 94.367500f, 93.657300f, 92.947000f,  // 580-584
            92.236800f, 91.526600f, 90.816300f, 90.106100f, 89.395800f,  // 585-589
            88.685600f, 88.817700f, 88.949700f, 89.081800f, 89.213800f,  // 590-594
            89.345900f, 89.478000f, 89.610000f, 89.742100f, 89.874100f,  // 595-599
            90.006200f, 89.965500f, 89.924800f, 89.884100f, 89.843400f,  // 600-604
            89.802600f, 89.761900f, 89.721200f, 89.680500f, 89.639800f,  // 605-609
            89.599100f, 89.409100f, 89.219000f, 89.029000f, 88.838900f,  // 610-614
            88.648900f, 88.458900f, 88.268800f, 88.078800f, 87.888700f,  // 615-619
            87.698700f, 87.257700f, 86.816700f, 86.375700f, 85.934700f,  // 620-624
            85.493600f, 85.052600f, 84.611600f, 84.170600f, 83.729600f,  // 625-629
            83.288600f, 83.329700f, 83.370700f, 83.411800f, 83.452800f,  // 630-634
            83.493900f, 83.535000f, 83.576000f, 83.617100f, 83.658100f,  // 635-639
            83.699200f, 83.332000f, 82.964700f, 82.597500f, 82.230200f,  // 640-644
            81.863000f, 81.495800f, 81.128500f, 80.761300f, 80.394000f,  // 645-649
            80.026800f, 80.045600f, 80.064400f, 80.083100f, 80.101900f,  // 650-654
            80.120700f, 80.139500f, 80.158300f, 80.177000f, 80.195800f,  // 655-659
            80.214600f, 80.420900f, 80.627200f, 80.833600f, 81.039900f,  // 660-664
            81.246200f, 81.452500f, 81.658800f, 81.865200f, 82.071500f,  // 665-669
            82.277800f, 81.878400f, 81.479100f, 81.079700f, 80.680400f,  // 670-674
            80.281000f, 79.881600f, 79.482300f, 79.082900f, 78.683600f,  // 675-679
            78.284200f, 77.427900f, 76.571600f, 75.715300f, 74.859000f,  // 680-684
            74.002700f, 73.146500f, 72.290200f, 71.433900f, 70.577600f,  // 685-689
            69.721300f, 69.910100f, 70.098900f, 70.287600f, 70.476400f,  // 690-694
            70.665200f, 70.854000f, 71.042800f, 71.231500f, 71.420300f,  // 695-699
            71.609100f, 71.883100f, 72.157100f, 72.431100f, 72.705100f,  // 700-704
            72.979000f, 73.253000f, 73.527000f, 73.801000f, 74.075000f,  // 705-709
            74.349000f, 73.074500f, 71.800000f, 70.525500f, 69.251000f,  // 710-714
            67.976500f, 66.702000f, 65.427500f, 64.153000f, 62.878500f,  // 715-719
            61.604000f, 62.432200f, 63.260300f, 64.088500f, 64.916600f,  // 720-724
            65.744800f, 66.573000f, 67.401100f, 68.229300f, 69.057400f,  // 725-729
            69.885600f, 70.405700f, 70.925900f, 71.446000f, 71.966200f,  // 730-734
            72.486300f, 73.006400f, 73.526600f, 74.046700f, 74.566900f,  // 735-739
            75.087000f, 73.937600f, 72.788100f, 71.638700f, 70.489300f,  // 740-744
            69.339800f, 68.190400f, 67.041000f, 65.891600f, 64.742100f,  // 745-749
            63.592700f, 61.875200f, 60.157800f, 58.440300f, 56.722900f,  // 750-754
            55.005400f, 53.288000f, 51.570500f, 49.853100f, 48.135600f,  // 755-759
            46.418200f, 48.456900f, 50.495600f, 52.534400f, 54.573100f,  // 760-764
            56.611800f, 58.650500f, 60.689200f, 62.728000f, 64.766700f,  // 765-769
            66.805400f, 66.463100f, 66.120900f, 65.778600f, 65.436400f,  // 770-774
            65.094100f, 64.751800f, 64.409600f, 64.067300f, 63.725100f,  // 775-779
            63.382800f, 63.474900f, 63.567000f, 63.659200f, 63.751300f,  // 780-784
            63.843400f, 63.935500f, 64.027600f, 64.119800f, 64.211900f,  // 785-789
            64.304000f, 63.818800f, 63.333600f, 62.848400f, 62.363200f,  // 790-794
            61.877900f, 61.392700f, 60.907500f, 60.422300f, 59.937100f,  // 795-799
            59.451900f, 58.702600f, 57.953300f, 57.204000f, 56.454700f,  // 800-804
            55.705400f, 54.956200f, 54.206900f, 53.457600f, 52.708300f,  // 805-809
            51.959000f, 52.507200f, 53.055300f, 53.603500f, 54.151600f,  // 810-814
            54.699800f, 55.248000f, 55.796100f, 56.344300f, 56.892400f,  // 815-819
            57.440600f, 57.727800f, 58.015000f, 58.302200f, 58.589400f,  // 820-824
            58.876500f, 59.163700f, 59.450900f, 59.738100f, 60.025300f,  // 825-829
            60.312500f                                                       // 830
        };

    public D65()
    {
        super( 300, 1, m_Readings );
    }
}
