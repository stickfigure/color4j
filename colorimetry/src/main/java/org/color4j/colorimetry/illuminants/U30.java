/*
 * Copyright (c) 2011 Niclas Hedhman.
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

public class U30 extends Spectrum
{
    static final long serialVersionUID = 1L;

    private static float[] m_Readings =
        {
            // 300-304
            // 305-309
            // 310-314
            // 315-319
            // 320-324
            // 325-329
            // 330-334
            // 335-339
            // 340-344
            // 345-349
            // 350-354
            // 355-359
            // 360-364
            // 365-369
            // 370-374
            // 375-379
            0.960f, 0.896f, 0.832f, 0.768f, 0.704f,  // 380-384
            0.640f, 0.592f, 0.544f, 0.496f, 0.448f,  // 385-389
            0.400f, 0.386f, 0.372f, 0.358f, 0.344f,  // 390-394
            0.330f, 0.502f, 0.674f, 0.846f, 1.018f,  // 395-399
            1.190f, 3.448f, 5.706f, 7.964f, 10.222f,  // 400-404
            12.480f, 10.208f, 7.936f, 5.664f, 3.392f,  // 405-409
            1.120f, 1.084f, 1.048f, 1.012f, 0.976f,  // 410-414
            0.940f, 0.968f, 0.996f, 1.024f, 1.052f,  // 415-419
            1.080f, 1.138f, 1.196f, 1.254f, 1.312f,  // 420-424
            1.370f, 1.452f, 1.534f, 1.616f, 1.698f,  // 425-429
            1.780f, 7.234f, 12.688f, 18.142f, 23.596f,  // 430-434
            29.050f, 24.820f, 20.590f, 16.360f, 12.130f,  // 435-439
            7.900f, 6.850f, 5.800f, 4.750f, 3.700f,  // 440-444
            2.650f, 2.662f, 2.674f, 2.686f, 2.698f,  // 445-449
            2.710f, 2.698f, 2.686f, 2.674f, 2.662f,  // 450-454
            2.650f, 2.618f, 2.586f, 2.554f, 2.522f,  // 455-459
            2.490f, 2.458f, 2.426f, 2.394f, 2.362f,  // 460-464
            2.330f, 2.284f, 2.238f, 2.192f, 2.146f,  // 465-469
            2.100f, 2.062f, 2.024f, 1.986f, 1.948f,  // 470-474
            1.910f, 2.130f, 2.350f, 2.570f, 2.790f,  // 475-479
            3.010f, 4.574f, 6.138f, 7.702f, 9.266f,  // 480-484
            10.830f, 11.040f, 11.250f, 11.460f, 11.670f,  // 485-489
            11.880f, 10.880f, 9.880f, 8.880f, 7.880f,  // 490-494
            6.880f, 6.190f, 5.500f, 4.810f, 4.120f,  // 495-499
            3.430f, 3.042f, 2.654f, 2.266f, 1.878f,  // 500-504
            1.490f, 1.376f, 1.262f, 1.148f, 1.034f,  // 505-509
            0.920f, 0.878f, 0.836f, 0.794f, 0.752f,  // 510-514
            0.710f, 0.688f, 0.666f, 0.644f, 0.622f,  // 515-519
            0.600f, 0.606f, 0.612f, 0.618f, 0.624f,  // 520-524
            0.630f, 0.724f, 0.818f, 0.912f, 1.006f,  // 525-529
            1.100f, 1.792f, 2.484f, 3.176f, 3.868f,  // 530-534
            4.560f, 10.528f, 16.496f, 22.464f, 28.432f,  // 535-539
            34.400f, 40.600f, 46.800f, 53.000f, 59.200f,  // 540-544
            65.400f, 58.216f, 51.032f, 43.848f, 36.664f,  // 545-549
            29.480f, 25.016f, 20.552f, 16.088f, 11.624f,  // 550-554
            7.160f, 6.344f, 5.528f, 4.712f, 3.896f,  // 555-559
            3.080f, 2.958f, 2.836f, 2.714f, 2.592f,  // 560-564
            2.470f, 2.430f, 2.390f, 2.350f, 2.310f,  // 565-569
            2.270f, 2.834f, 3.398f, 3.962f, 4.526f,  // 570-574
            5.090f, 6.464f, 7.838f, 9.212f, 10.586f,  // 575-579
            11.960f, 12.632f, 13.304f, 13.976f, 14.648f,  // 580-584
            15.320f, 15.110f, 14.900f, 14.690f, 14.480f,  // 585-589
            14.270f, 13.788f, 13.306f, 12.824f, 12.342f,  // 590-594
            11.860f, 11.344f, 10.828f, 10.312f, 9.796f,  // 595-599
            9.280f, 9.886f, 10.492f, 11.098f, 11.704f,  // 600-604
            12.310f, 23.554f, 34.798f, 46.042f, 57.286f,  // 605-609
            68.530f, 65.428f, 62.326f, 59.224f, 56.122f,  // 610-614
            53.020f, 45.350f, 37.680f, 30.010f, 22.340f,  // 615-619
            14.670f, 14.612f, 14.554f, 14.496f, 14.438f,  // 620-624
            14.380f, 14.446f, 14.512f, 14.578f, 14.644f,  // 625-629
            14.710f, 13.060f, 11.410f, 9.760f, 8.110f,  // 630-634
            6.460f, 5.682f, 4.904f, 4.126f, 3.348f,  // 635-639
            2.570f, 2.606f, 2.642f, 2.678f, 2.714f,  // 640-644
            2.750f, 3.036f, 3.322f, 3.608f, 3.894f,  // 645-649
            4.180f, 4.032f, 3.884f, 3.736f, 3.588f,  // 650-654
            3.440f, 3.314f, 3.188f, 3.062f, 2.936f,  // 655-659
            2.810f, 2.732f, 2.654f, 2.576f, 2.498f,  // 660-664
            2.420f, 2.264f, 2.108f, 1.952f, 1.796f,  // 665-669
            1.640f, 1.584f, 1.528f, 1.472f, 1.416f,  // 670-674
            1.360f, 1.386f, 1.412f, 1.438f, 1.464f,  // 675-679
            1.490f, 1.620f, 1.750f, 1.880f, 2.010f,  // 680-684
            2.140f, 2.180f, 2.220f, 2.260f, 2.300f,  // 685-689
            2.340f, 2.156f, 1.972f, 1.788f, 1.604f,  // 690-694
            1.420f, 1.458f, 1.496f, 1.534f, 1.572f,  // 695-699
            1.610f, 2.296f, 2.982f, 3.668f, 4.354f,  // 700-704
            5.040f, 5.428f, 5.816f, 6.204f, 6.592f,  // 705-709
            6.980f, 6.222f, 5.464f, 4.706f, 3.948f,  // 710-714
            3.190f, 2.694f, 2.198f, 1.702f, 1.206f,  // 715-719
            0.710f, 0.628f, 0.546f, 0.464f, 0.382f,  // 720-724
            0.300f, 0.292f, 0.284f, 0.276f, 0.268f,  // 725-729
            0.260f, 0.254f, 0.248f, 0.242f, 0.236f,  // 730-734
            0.230f, 0.240f, 0.250f, 0.260f, 0.270f,  // 735-739
            0.280f, 0.280f, 0.280f, 0.280f, 0.280f,  // 740-744
            0.280f, 0.266f, 0.252f, 0.238f, 0.224f,  // 745-749
            0.210f, 0.202f, 0.194f, 0.186f, 0.178f,  // 750-754
            0.170f, 0.178f, 0.186f, 0.194f, 0.202f,  // 755-759
            0.210f, 0.206f, 0.202f, 0.198f, 0.194f,  // 760-764
            0.190f, 0.182f, 0.174f, 0.166f, 0.158f,  // 765-769
            0.150f, 0.140f, 0.130f, 0.120f, 0.110f,  // 770-774
            0.100f, 0.090f, 0.080f, 0.070f, 0.060f,  // 775-779
            0.050f                                       // 780-784
            // 785-789
            // 790-794
            // 795-799
            // 800-804
            // 805-809
            // 810-814
            // 815-819
            // 820-824
            // 825-829
            // 830
        };

    public U30()
    {
        super( 380, 1, m_Readings );
    }
}
