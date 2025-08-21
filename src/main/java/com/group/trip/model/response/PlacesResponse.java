package com.group.trip.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacesResponse {
    
    private List<Place> results;
    private String status;
    private String errorMessage;
    private List<String> htmlAttributions;
    private String nextPageToken;
    
    // For place details response
    private Place result;
    
    // For find place response
    private List<PlaceCandidate> candidates;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Place {
        private String placeId;
        private String name;
        private String vicinity;
        private List<String> types;
        private Double rating;
        private Integer userRatingsTotal;
        private Integer priceLevel;
        private Geometry geometry;
        private List<Photo> photos;
        private OpeningHours openingHours;
        private String formattedAddress;
        private String formattedPhoneNumber;
        private String website;
        private List<Review> reviews;
        private String businessStatus;
        private String icon;
        private String iconBackgroundColor;
        private String iconMaskBaseUri;
        private PlusCode plusCode;
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Geometry {
            private Location location;
            private Viewport viewport;
            
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Location {
                private Double lat;
                private Double lng;
            }
            
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Viewport {
                private Location northeast;
                private Location southwest;
            }
        }
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Photo {
            private Integer height;
            private Integer width;
            private List<String> htmlAttributions;
            private String photoReference;
        }
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class OpeningHours {
            private Boolean openNow;
            private List<String> weekdayText;
            private List<Period> periods;
            
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Period {
                private TimeDetail open;
                private TimeDetail close;
                
                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                public static class TimeDetail {
                    private Integer day;
                    private String time;
                }
            }
        }
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Review {
            private String authorName;
            private String authorUrl;
            private String language;
            private String profilePhotoUrl;
            private Integer rating;
            private String relativeTimeDescription;
            private String text;
            private Long time;
        }
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PlusCode {
            private String compoundCode;
            private String globalCode;
        }
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlaceCandidate {
        private String placeId;
        private String name;
        private Geometry geometry;
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Geometry {
        private Location location;
        private Viewport viewport;
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Location {
            private Double lat;
            private Double lng;
        }
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Viewport {
            private Location northeast;
            private Location southwest;
        }
    }
}
