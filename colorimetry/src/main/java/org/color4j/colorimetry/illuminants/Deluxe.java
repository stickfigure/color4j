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

public class Deluxe extends Spectrum
{
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
            2.560f, 2.650f, 2.765f, 2.896f, 3.036f,    // 380-384
            3.180f, 3.322f, 3.460f, 3.592f, 3.718f,    // 385-389
            3.840f, 3.960f, 4.082f, 4.213f, 4.360f,    // 390-394
            4.530f, 4.735f, 4.985f, 5.295f, 5.678f,    // 395-399
            6.150f, 8.794f, 11.438f, 14.082f, 16.726f,    // 400-404
            19.370f, 16.970f, 14.570f, 12.170f, 9.770f,    // 405-409
            7.370f, 7.151f, 7.025f, 6.976f, 6.989f,    // 410-414
            7.050f, 7.147f, 7.270f, 7.410f, 7.558f,    // 415-419
            7.710f, 7.860f, 8.006f, 8.146f, 8.280f,    // 420-424
            8.410f, 8.538f, 8.670f, 8.810f, 8.967f,    // 425-429
            9.150f, 16.148f, 23.146f, 30.144f, 37.142f,    // 430-434
            44.140f, 38.816f, 33.492f, 28.168f, 22.844f,    // 435-439
            17.520f, 16.286f, 15.052f, 13.818f, 12.584f,    // 440-444
            11.350f, 11.497f, 11.631f, 11.758f, 11.880f,    // 445-449
            12.000f, 12.119f, 12.237f, 12.353f, 12.468f,    // 450-454
            12.580f, 12.689f, 12.794f, 12.895f, 12.990f,    // 455-459
            13.080f, 13.165f, 13.244f, 13.317f, 13.386f,    // 460-464
            13.450f, 13.510f, 13.565f, 13.617f, 13.665f,    // 465-469
            13.710f, 13.751f, 13.789f, 13.824f, 13.854f,    // 470-474
            13.880f, 13.902f, 13.919f, 13.932f, 13.942f,    // 475-479
            13.950f, 13.961f, 13.961f, 13.955f, 13.944f,    // 480-484
            13.930f, 13.913f, 13.894f, 13.872f, 13.848f,    // 485-489
            13.820f, 13.789f, 13.756f, 13.719f, 13.681f,    // 490-494
            13.640f, 13.598f, 13.555f, 13.513f, 13.471f,    // 495-499
            13.430f, 13.391f, 13.353f, 13.317f, 13.283f,    // 500-504
            13.250f, 13.217f, 13.185f, 13.151f, 13.116f,    // 505-509
            13.080f, 13.043f, 13.006f, 12.972f, 12.945f,    // 510-514
            12.930f, 12.905f, 12.877f, 12.847f, 12.814f,    // 515-519
            12.780f, 12.745f, 12.709f, 12.672f, 12.636f,    // 520-524
            12.600f, 12.565f, 12.531f, 12.499f, 12.469f,    // 525-529
            12.440f, 12.414f, 12.389f, 12.368f, 12.348f,    // 530-534
            12.330f, 12.314f, 12.300f, 12.286f, 12.273f,    // 535-539
            12.260f, 15.712f, 19.164f, 22.616f, 26.068f,    // 540-544
            29.520f, 27.026f, 24.532f, 22.038f, 19.544f,    // 545-549
            17.050f, 16.128f, 15.206f, 14.284f, 13.362f,    // 550-554
            12.440f, 12.467f, 12.494f, 12.522f, 12.551f,    // 555-559
            12.580f, 12.609f, 12.638f, 12.666f, 12.693f,    // 560-564
            12.720f, 12.745f, 12.769f, 12.792f, 12.812f,    // 565-569
            12.830f, 13.356f, 13.882f, 14.408f, 14.934f,    // 570-574
            15.460f, 15.718f, 15.976f, 16.234f, 16.492f,    // 575-579
            16.750f, 15.966f, 15.182f, 14.398f, 13.614f,    // 580-584
            12.830f, 12.623f, 12.598f, 12.632f, 12.663f,    // 585-589
            12.670f, 12.651f, 12.612f, 12.561f, 12.505f,    // 590-594
            12.450f, 12.396f, 12.345f, 12.294f, 12.243f,    // 595-599
            12.190f, 12.134f, 12.076f, 12.015f, 11.953f,    // 600-604
            11.890f, 11.828f, 11.768f, 11.709f, 11.654f,    // 605-609
            11.600f, 11.548f, 11.498f, 11.448f, 11.399f,    // 610-614
            11.350f, 11.301f, 11.254f, 11.207f, 11.162f,    // 615-619
            11.120f, 11.081f, 11.045f, 11.011f, 10.980f,    // 620-624
            10.950f, 10.920f, 10.887f, 10.851f, 10.809f,    // 625-629
            10.760f, 10.704f, 10.641f, 10.571f, 10.496f,    // 630-634
            10.420f, 10.344f, 10.273f, 10.208f, 10.153f,    // 635-639
            10.110f, 10.078f, 10.058f, 10.047f, 10.042f,    // 640-644
            10.040f, 10.039f, 10.035f, 10.030f, 10.024f,    // 645-649
            10.020f, 10.023f, 10.035f, 10.058f, 10.087f,    // 650-654
            10.110f, 10.108f, 10.061f, 9.963f, 9.853f,    // 655-659
            9.870f, 9.742f, 9.530f, 9.263f, 8.963f,    // 660-664
            8.650f, 8.338f, 8.039f, 7.758f, 7.501f,    // 665-669
            7.270f, 7.064f, 6.882f, 6.719f, 6.574f,    // 670-674
            6.440f, 6.314f, 6.192f, 6.072f, 5.951f,    // 675-679
            5.830f, 5.711f, 5.600f, 5.505f, 5.436f,    // 680-684
            5.410f, 3.131f, 3.341f, 4.113f, 4.731f,    // 685-689
            5.040f, 5.097f, 5.007f, 4.858f, 4.705f,    // 690-694
            4.570f, 4.457f, 4.362f, 4.278f, 4.198f,    // 695-699
            4.120f, 4.044f, 3.970f, 3.899f, 3.833f,    // 700-704
            3.770f, 3.710f, 3.650f, 3.590f, 3.527f,    // 705-709
            3.460f, 3.389f, 3.315f, 3.237f, 3.159f,    // 710-714
            3.080f, 3.003f, 2.929f, 2.858f, 2.792f,    // 715-719
            2.730f, 2.672f, 2.618f, 2.566f, 2.517f,    // 720-724
            2.470f, 2.424f, 2.379f, 2.335f, 2.292f,    // 725-729
            2.250f, 2.209f, 2.170f, 2.132f, 2.095f,    // 730-734
            2.060f, 2.026f, 1.994f, 1.962f, 1.931f,    // 735-739
            1.900f, 1.870f, 1.839f, 1.809f, 1.779f,    // 740-744
            1.750f, 1.721f, 1.693f, 1.667f, 1.642f,    // 745-749
            1.620f, 1.600f, 1.582f, 1.567f, 1.553f,    // 750-754
            1.540f, 1.527f, 1.512f, 1.495f, 1.474f,    // 755-759
            1.450f, 1.423f, 1.394f, 1.366f, 1.341f,    // 760-764
            1.320f, 1.303f, 1.288f, 1.267f, 1.231f,    // 765-769
            1.170f, 1.078f, 0.963f, 0.858f, 0.832f,    // 770-774
            0.990f, 1.448f, 2.256f, 3.206f, 3.451f,    // 775-779
            0.810f                                         // 780-784
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

    public Deluxe()
    {
        super( 380, 1, m_Readings );
    }
}
